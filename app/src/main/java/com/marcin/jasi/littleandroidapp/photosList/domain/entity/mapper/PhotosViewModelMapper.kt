package com.marcin.jasi.littleandroidapp.photosList.domain.entity.mapper

import com.marcin.jasi.littleandroidapp.general.domain.mapper.DataMapper
import com.marcin.jasi.littleandroidapp.photosList.domain.entity.Photo
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.PhotosListItemViewModel


class PhotosViewModelMapper : DataMapper<Photo, PhotosListItemViewModel>() {

    override fun transform(from: Photo): PhotosListItemViewModel {
        return PhotosListItemViewModel(from)
    }

}