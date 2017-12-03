package com.marcin.jasi.littleandroidapp.details.presentation.viewModel

import com.marcin.jasi.littleandroidapp.details.domain.entity.Details
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModel

class DetailsItemViewModel(var item: Details) : CommonViewModel {

    companion object {
        val TITLE_TEXT = "Item: %s"
    }

    fun getUrl(): String = item.url

    fun getTitle(): String = String.format(TITLE_TEXT, item.id)

}