package com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel

import android.databinding.ObservableInt
import android.view.View
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModel

class InfiniteScrollingProgressViewModel : CommonViewModel {

    private var progressBarVisibility: ObservableInt = ObservableInt(View.INVISIBLE)

    fun showProgressBar() {
        progressBarVisibility.set(View.VISIBLE)
    }

    fun hideProgressBar() {
        progressBarVisibility.set(View.INVISIBLE)
    }

    fun getProgressBarVisibility(): ObservableInt = progressBarVisibility
}