package com.marcin.jasi.littleandroidapp.details.presentation.viewModel

import android.databinding.ObservableInt
import android.view.View
import com.marcin.jasi.littleandroidapp.details.domain.entity.Buttons
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModel

class ButtonsItemViewModel(var item: Buttons) : CommonViewModel {

    var frontButtonVisibilityObservable = ObservableInt(View.VISIBLE)
    var topButtonVisibilityObservable = ObservableInt(View.VISIBLE)

    fun topButtonClick() = View.OnClickListener {

    }

    fun frontButtonClick() = View.OnClickListener {
        frontButtonVisibilityObservable.set(View.GONE)
    }

    fun backButtonClick() = View.OnClickListener {
        topButtonVisibilityObservable.set(View.INVISIBLE)
    }

    fun getFrontButtonVisibility() = frontButtonVisibilityObservable

    fun getTopButtonVisibility() = topButtonVisibilityObservable
}