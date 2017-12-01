package com.marcin.jasi.littleandroidapp.main.presentation.viewModel

import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModelImpl
import com.marcin.jasi.littleandroidapp.main.presentation.viewPager.MainActivityViewPager
import javax.inject.Inject

class MainActivityViewModelImpl @Inject constructor() : CommonViewModelImpl(), MainActivityViewModel {

    @Inject
    lateinit var adapter: MainActivityViewPager

    override fun getViewPager(): MainActivityViewPager {
        return adapter
    }
}