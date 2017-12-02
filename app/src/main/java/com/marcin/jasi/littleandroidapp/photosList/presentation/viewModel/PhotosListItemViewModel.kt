package com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel

import com.marcin.jasi.littleandroidapp.photosList.domain.entity.Photo

class PhotosListItemViewModel(var item: Photo) {

    companion object {
        val TITLE_TEXT = "Item: %s"
    }

    fun getUrl(): String = item.url

    fun getTitle(): String = String.format(TITLE_TEXT, item.id)

}