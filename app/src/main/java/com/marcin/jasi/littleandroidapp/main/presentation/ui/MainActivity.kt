package com.marcin.jasi.littleandroidapp.main.presentation.ui

import android.databinding.DataBindingUtil
import android.widget.Toast
import com.marcin.jasi.littleandroidapp.R
import com.marcin.jasi.littleandroidapp.databinding.ActivityMainBinding
import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerActivity
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonActivity
import com.marcin.jasi.littleandroidapp.main.presentation.viewModel.MainActivityViewModel
import com.marcin.jasi.littleandroidapp.main.presentation.viewPager.MainActivityViewPager
import java.util.*
import javax.inject.Inject

@PerActivity
class MainActivity : CommonActivity<MainActivityViewModel>() {

    companion object {
        val BACK_CLICK_FREQUENCY = 2000
    }

    @Inject
    lateinit var adapter: MainActivityViewPager

    lateinit var binding: ActivityMainBinding
    var lastBackClickInMilis: Long = 0


    override fun bindData() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun initialize() {
        binding.viewPager.adapter = adapter
    }

    override fun onBackPressed() {
        val currentTime = Calendar.getInstance().timeInMillis

        if (currentTime - lastBackClickInMilis < BACK_CLICK_FREQUENCY)
            super.onBackPressed()

        lastBackClickInMilis = currentTime
        showBackClickToast()
    }

    private fun showBackClickToast() {
        Toast.makeText(this, getString(R.string.exit_app_toast_text), Toast.LENGTH_SHORT).show()
    }
}