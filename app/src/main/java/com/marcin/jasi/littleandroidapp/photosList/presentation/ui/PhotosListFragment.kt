package com.marcin.jasi.littleandroidapp.photosList.presentation.ui

import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marcin.jasi.littleandroidapp.databinding.PhotosListFragmentBinding
import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerFragment
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonFragment
import com.marcin.jasi.littleandroidapp.photosList.domain.interactor.GetPhotosList
import com.marcin.jasi.littleandroidapp.photosList.domain.interactor.GetPhotosList.Companion.FIRST_SIDE
import com.marcin.jasi.littleandroidapp.photosList.presentation.adapter.PhotosListAdapter
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.PhotosListItemViewModel
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.PhotosListViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.*
import javax.inject.Inject

@PerFragment
class PhotosListFragment : CommonFragment<PhotosListViewModel>() {

    @Inject
    lateinit var adapter: PhotosListAdapter
    lateinit var binding: PhotosListFragmentBinding

    override fun bindData(inflater: LayoutInflater, container: ViewGroup?) {
        binding = PhotosListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
    }

    override fun getRootView(): View {
        return binding.root
    }

    override fun initialize() {
        initRecyclerView()
        viewModel.resetHeaderColor()
        subscribeGetNewData()
        viewModel.loadData(FIRST_SIDE)
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter

        disposable.add(adapter.endScrollSubject.subscribe({ lastScrollerdId -> viewModel.loadData(lastScrollerdId) }))
    }

    private fun setAwaitingForScrollDown() {
        adapter.awaitingForScrollDown = true
    }

    private fun subscribeGetNewData() {
        disposable.add(
                viewModel.getLoadNewDataSubject()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext({ dataList -> checkIfLastDada(dataList) })
                        .map { data ->
                            mergeLists(data)
                            sortList(data)
                            setAwaitingForScrollDown()

                            var result = adapter.getDiffResult(data)
                            Pair(data, result)
                        }
                        .doOnError { throwable -> Timber.d(throwable.message) }
                        .subscribe({ data -> updateList(data) }))
    }

    private fun checkIfLastDada(dataList: List<PhotosListItemViewModel>) {
        if (dataList.size < GetPhotosList.PACK_SIZE)
            viewModel.setLastDataDownloaded(true)
    }

    private fun mergeLists(data: List<PhotosListItemViewModel>) {
        (data as ArrayList<PhotosListItemViewModel>).addAll(adapter.items)
    }

    private fun sortList(data: List<PhotosListItemViewModel>) {
        Collections.sort(data, { o1, o2 ->
            when {
                o1.item.id > o2.item.id -> 1
                o1.item.id == o2.item.id -> 0
                o1.item.id < o2.item.id -> -1
                else -> 0
            }
        })
    }

    private fun updateList(data: Pair<List<PhotosListItemViewModel>, DiffUtil.DiffResult>) {
        adapter.setItems(data.first)
        data.second.dispatchUpdatesTo(adapter)
    }

}