package com.marcin.jasi.littleandroidapp.main.presentation.ui

import android.databinding.DataBindingUtil
import com.marcin.jasi.littleandroidapp.R
import com.marcin.jasi.littleandroidapp.databinding.ActivityMainBinding
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonActivity
import com.marcin.jasi.littleandroidapp.main.presentation.viewModel.MainActivityViewModel

class MainActivity :CommonActivity<MainActivityViewModel>(){

    lateinit var binding: ActivityMainBinding


    override fun bindData() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun initialize() {

    }

}