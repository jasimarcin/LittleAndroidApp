package com.marcin.jasi.littleandroidapp.photosList.presentation.ui

import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marcin.jasi.littleandroidapp.databinding.PhotosListFragmentBinding
import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerFragment
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonFragment
import com.marcin.jasi.littleandroidapp.photosList.presentation.adapter.PhotosListAdapter
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.PhotosListItemViewModel
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.PhotosListViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
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
        viewModel.loadData()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter
    }

    private fun subscribeGetNewData() {
        disposable.add(
                viewModel.getLoadNewDataSubject()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map { data ->
                            var result = adapter.getDiffResult(data)
                            Pair<List<PhotosListItemViewModel>, DiffUtil.DiffResult>(data, result);
                        }
                        .doOnError { throwable -> Timber.d(throwable.message) }
                        .subscribe({ data -> updateList(data) }))
    }

    private fun updateList(data: Pair<List<PhotosListItemViewModel>, DiffUtil.DiffResult>) {
        adapter.setItems(data.first)
        data.second.dispatchUpdatesTo(adapter)
    }

}