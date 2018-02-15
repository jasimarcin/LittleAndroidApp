package com.marcin.jasi.littleandroidapp.photosList.presentation.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.marcin.jasi.littleandroidapp.R
import com.marcin.jasi.littleandroidapp.databinding.PhotosListRowBinding
import com.marcin.jasi.littleandroidapp.databinding.RowProgressBarBinding
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModel
import com.marcin.jasi.littleandroidapp.general.presentation.viewHolder.BaseRecyclerViewHolder
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewHolder.InfiniteScrollingProgressViewHolder
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewHolder.PhotoItemViewHolder
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.InfiniteScrollingProgressViewModel
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.PhotosListItemViewModel
import io.reactivex.subjects.ReplaySubject

class PhotosListAdapter(var progressBarViewModel: InfiniteScrollingProgressViewModel)
    : RecyclerView.Adapter<BaseRecyclerViewHolder<ViewDataBinding, CommonViewModel>>() {

    companion object {
       const val ITEM: Int = 0
       const val PROGRESS_BAR: Int = 1
       const val AWAIT_SCROLL_DOWN_BEFORE = 4
    }

    var endScrollSubject = ReplaySubject.create<Int>()
    var items: ArrayList<PhotosListItemViewModel> = ArrayList()
    var awaitingForScrollDown: Boolean = false

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<ViewDataBinding, CommonViewModel>?, position: Int) {

        if (getItemViewType(position) == PROGRESS_BAR) {
            holder!!.bind(progressBarViewModel)
        } else if (getItemViewType(position) == ITEM) {
            holder!!.bind(items[position])
            checkScrollDown(position)
        }

    }

    private fun checkScrollDown(position: Int) {
        if (!awaitingForScrollDown)
            return

        if (position <= itemCount - AWAIT_SCROLL_DOWN_BEFORE)
            return

        awaitingForScrollDown = false
        endScrollSubject.onNext(itemCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseRecyclerViewHolder<ViewDataBinding, CommonViewModel> {
        val inflater = LayoutInflater.from(parent!!.context)

        return if (viewType == PROGRESS_BAR) {
            val progressBarBinding: RowProgressBarBinding = DataBindingUtil.inflate(inflater, R.layout.row_progress_bar, parent, false)
            InfiniteScrollingProgressViewHolder(progressBarBinding)
        } else {
            val binding: PhotosListRowBinding = DataBindingUtil.inflate(inflater, R.layout.photos_list_row, parent, false)
            PhotoItemViewHolder(binding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            itemCount - 1 -> PROGRESS_BAR
            else -> ITEM
        }
    }

    override fun getItemCount(): Int = items.size + 1

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