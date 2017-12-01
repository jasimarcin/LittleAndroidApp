package com.marcin.jasi.littleandroidapp.main.presentation.viewModel

import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModel
import com.marcin.jasi.littleandroidapp.main.presentation.viewPager.MainActivityViewPager

interface MainActivityViewModel : CommonViewModel {

    fun getViewPager(): MainActivityViewPager
}