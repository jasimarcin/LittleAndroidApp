package com.marcin.jasi.littleandroidapp.general.presentation.viewHolder

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

abstract class BaseRecyclerViewHolder<V : ViewDataBinding, VM>(var view: V) : RecyclerView.ViewHolder(view.root) {
    abstract fun bind(viewModel: VM)
}