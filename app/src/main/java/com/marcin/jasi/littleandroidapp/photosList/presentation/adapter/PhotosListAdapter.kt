package com.marcin.jasi.littleandroidapp.photosList.presentation.adapter

import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.marcin.jasi.littleandroidapp.R
import com.marcin.jasi.littleandroidapp.databinding.PhotosListRowBinding
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewHolder.PhotoItemViewHolder
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.PhotosListItemViewModel
import io.reactivex.subjects.ReplaySubject

class PhotosListAdapter : RecyclerView.Adapter<PhotoItemViewHolder>() {

    companion object {
        val AWAIT_SCROLL_DOWN_BEFORE = 4
    }

    var endScrollSubject = ReplaySubject.create<Int>()
    var items: ArrayList<PhotosListItemViewModel> = ArrayList()
    var awaitingForScrollDown: Boolean = false

    override fun onBindViewHolder(holder: PhotoItemViewHolder?, position: Int) {
        holder!!.bind(items[position])
        checkScrollDown(position)
    }

    private fun checkScrollDown(position: Int) {
        if (!awaitingForScrollDown)
            return

        if (position <= itemCount - AWAIT_SCROLL_DOWN_BEFORE)
            return

        awaitingForScrollDown = false
        endScrollSubject.onNext(itemCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoItemViewHolder {
        var inflater = LayoutInflater.from(parent!!.context)
        var binding: PhotosListRowBinding = DataBindingUtil.inflate(inflater, R.layout.photos_list_row, parent, false)

        return PhotoItemViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    fun getDiffResult(items: List<PhotosListItemViewModel>): DiffUtil.DiffResult {
        return DiffUtil.calculateDiff(getDiffCallback(items))
    }

    private fun getDiffCallback(items: List<PhotosListItemViewModel>): DiffUtil.Callback {
        return object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = compareObjects(oldItemPosition, newItemPosition)


            override fun getOldListSize(): Int = this@PhotosListAdapter.items.size

            override fun getNewListSize(): Int = items.size

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = compareObjects(oldItemPosition, newItemPosition)

            fun compareObjects(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return this@PhotosListAdapter.items[oldItemPosition].getUrl().equals(items[newItemPosition].getUrl()) &&
                        this@PhotosListAdapter.items[oldItemPosition].getTitle().equals(items[newItemPosition].getTitle())
            }
        }
    }

    fun setItems(items: List<PhotosListItemViewModel>) {
        this@PhotosListAdapter.items = items as ArrayList<PhotosListItemViewModel>
    }
}