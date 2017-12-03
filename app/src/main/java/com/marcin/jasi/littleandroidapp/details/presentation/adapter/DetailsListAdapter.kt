package com.marcin.jasi.littleandroidapp.details.presentation.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.marcin.jasi.littleandroidapp.R
import com.marcin.jasi.littleandroidapp.databinding.ButtonsRowBinding
import com.marcin.jasi.littleandroidapp.databinding.DetailsRowBinding
import com.marcin.jasi.littleandroidapp.databinding.LoadingRowBinding
import com.marcin.jasi.littleandroidapp.databinding.PercentageRowBinding
import com.marcin.jasi.littleandroidapp.details.presentation.viewHolder.ButtonsItemViewHolder
import com.marcin.jasi.littleandroidapp.details.presentation.viewHolder.DetailsListItemViewHolder
import com.marcin.jasi.littleandroidapp.details.presentation.viewHolder.LoadingItemViewHolder
import com.marcin.jasi.littleandroidapp.details.presentation.viewHolder.PercentageItemVIewHolder
import com.marcin.jasi.littleandroidapp.details.presentation.viewModel.ButtonsItemViewModel
import com.marcin.jasi.littleandroidapp.details.presentation.viewModel.LoadingItemViewModel
import com.marcin.jasi.littleandroidapp.details.presentation.viewModel.PercentageItemViewModel
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModel
import com.marcin.jasi.littleandroidapp.general.presentation.viewHolder.BaseRecyclerViewHolder

class DetailsListAdapter : RecyclerView.Adapter<BaseRecyclerViewHolder<ViewDataBinding, CommonViewModel>>() {

    companion object {
        val LOADING_ITEM = 0
        val BUTTONS_ITEM = 1
        val PERCENTAGE_ITEM = 2
        val DETAILS_ITEM = -1
    }

    var items: ArrayList<CommonViewModel> = ArrayList()

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<ViewDataBinding, CommonViewModel>?, position: Int) {
        holder!!.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseRecyclerViewHolder<ViewDataBinding, CommonViewModel> {
        val inflater = LayoutInflater.from(parent!!.context)

        if (viewType == LOADING_ITEM) {
            val loadingBinding: LoadingRowBinding = DataBindingUtil.inflate(inflater,
                    R.layout.loading_row, parent, false)
            return LoadingItemViewHolder(loadingBinding)

        } else if (viewType == BUTTONS_ITEM) {
            val buttonsBinding: ButtonsRowBinding = DataBindingUtil.inflate(inflater,
                    R.layout.buttons_row, parent, false)
            return ButtonsItemViewHolder(buttonsBinding)

        } else if (viewType == PERCENTAGE_ITEM) {
            val percentageBinding: PercentageRowBinding = DataBindingUtil.inflate(inflater,
                    R.layout.percentage_row, parent, false)
            return PercentageItemVIewHolder(percentageBinding)

        } else {
            val detailsBinding: DetailsRowBinding = DataBindingUtil.inflate(inflater,
                    R.layout.details_row, parent, false)
            return DetailsListItemViewHolder(detailsBinding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is LoadingItemViewModel -> LOADING_ITEM
            is ButtonsItemViewModel -> BUTTONS_ITEM
            is PercentageItemViewModel -> PERCENTAGE_ITEM
            else -> DETAILS_ITEM
        }
    }

    override fun getItemCount(): Int = items.size

}