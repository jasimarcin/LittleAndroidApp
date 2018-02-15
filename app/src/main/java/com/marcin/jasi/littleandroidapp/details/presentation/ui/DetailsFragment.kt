package com.marcin.jasi.littleandroidapp.details.presentation.ui

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marcin.jasi.littleandroidapp.databinding.DetailsFragmentBinding
import com.marcin.jasi.littleandroidapp.details.domain.entity.Buttons
import com.marcin.jasi.littleandroidapp.details.domain.entity.Details
import com.marcin.jasi.littleandroidapp.details.domain.entity.Loading
import com.marcin.jasi.littleandroidapp.details.domain.entity.Percentage
import com.marcin.jasi.littleandroidapp.details.presentation.adapter.DetailsListAdapter
import com.marcin.jasi.littleandroidapp.details.presentation.viewModel.*
import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerFragment
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonFragment
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModel
import com.marcin.jasi.littleandroidapp.general.presentation.helper.DialogHelper
import javax.inject.Inject


@PerFragment
class DetailsFragment : CommonFragment<DetailsFragmentViewModel>() {

    companion object {
        const val TEMPORARY_URL: String = "https://media.giphy.com/media/IHHzf3XSDzKec/giphy.gif"
    }

    @Inject
    lateinit var adapter: DetailsListAdapter
    @Inject
    lateinit var dialogHelper: DialogHelper
    lateinit var binding: DetailsFragmentBinding

    override fun bindData(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DetailsFragmentBinding.inflate(inflater, container, false)
    }

    override fun getRootView(): View {
        return binding.root
    }

    override fun initialize() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter

        setListData()
    }

    // can simulate backend like in photos section
    private fun setListData() {
        val list = ArrayList<CommonViewModel>()

        list.add(ButtonsItemViewModel(Buttons()))
        list.add(LoadingItemViewModel(Loading(), dialogHelper))
        list.add(PercentageItemViewModel(Percentage()))

        (1L..20L).mapTo(list) {
            DetailsItemViewModel(Details(TEMPORARY_URL, it))
        }

        activity.runOnUiThread({
            adapter.items = list
        })
    }
}