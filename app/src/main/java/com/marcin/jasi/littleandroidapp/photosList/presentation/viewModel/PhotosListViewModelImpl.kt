package com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel

import android.content.DialogInterface
import android.databinding.ObservableInt
import android.view.MotionEvent
import android.view.View
import com.marcin.jasi.littleandroidapp.R
import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerFragment
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModelImpl
import com.marcin.jasi.littleandroidapp.general.presentation.helper.ColorGenerator
import com.marcin.jasi.littleandroidapp.general.presentation.helper.DialogHelper
import javax.inject.Inject

@PerFragment
class PhotosListViewModelImpl @Inject constructor() : CommonViewModelImpl(), PhotosListViewModel {

    companion object {
        var GREEN_HEADER_COLOR = R.color.green_color
        var RED_HEADER_COLOR = R.color.red_color
        var BLUE_HEADER_COLOR = R.color.blue_color
        var WHITE_HEADER_COLOR = R.color.white_color
    }

    @Inject
    lateinit var colorGenerator: ColorGenerator
    @Inject
    lateinit var dialogHelper: DialogHelper
    @Inject
    lateinit var progressDialogController: ProgressDialogController

    var headerColorObservable: ObservableInt = ObservableInt()

    override fun resetHeaderColor() {
        headerColorObservable.set(colorGenerator.getColor(GREEN_HEADER_COLOR))
    }

    override fun getHeaderColor(): ObservableInt {
        return headerColorObservable
    }

    override fun getOnHeaderTouchListener(): View.OnTouchListener {
        return View.OnTouchListener(function = { view: View?, motionEvent: MotionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    callPressHeader()
                    true
                }
                MotionEvent.ACTION_CANCEL,
                MotionEvent.ACTION_UP -> {
                    callReleaseHeader()
                    true
                }
                else -> {
                    false
                }
            }
        })
    }

    fun callPressHeader() {
        setWhiteHeaderTextColor()
    }

    private fun setWhiteHeaderTextColor() {
        headerColorObservable.set(colorGenerator.getColor(WHITE_HEADER_COLOR))
    }

    fun callReleaseHeader() {
        setRedHeaderTextColor()
        showProgressDialog()
    }

    private fun setRedHeaderTextColor() {
        headerColorObservable.set(colorGenerator.getColor(RED_HEADER_COLOR))
    }

    private fun showProgressDialog() {
        val dialog = dialogHelper.showProgressBarDialog(progressDialogController)

        progressDialogController.callFinish.subscribe({ time ->
//            progressDialogController.onDispose()
            dialog.dismiss()
            validateIfCountingInterupted(time)
        })

        dialog.setOnDismissListener({ dialog -> progressDialogController.onDispose() })

        dialog.show()
        disposable.add(progressDialogController.startAnimation())
    }

    private fun validateIfCountingInterupted(time: Int?) {
        if (time == ProgressDialogController.END_PROGRESS)
            setBlueHeaderTextColor()
    }

    private fun setBlueHeaderTextColor() {
        headerColorObservable.set(colorGenerator.getColor(BLUE_HEADER_COLOR))
    }

}