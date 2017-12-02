package com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel

import android.databinding.ObservableInt
import android.view.View
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModel

interface PhotosListViewModel : CommonViewModel {

    fun getHeaderColor(): ObservableInt

    fun getOnHeaderTouchListener(): View.OnTouchListener

    fun resetHeaderColor()

}