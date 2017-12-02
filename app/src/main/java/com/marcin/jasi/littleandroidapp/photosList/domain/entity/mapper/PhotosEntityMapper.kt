package com.marcin.jasi.littleandroidapp.photosList.domain.entity.mapper

import com.marcin.jasi.littleandroidapp.general.domain.mapper.DataMapper
import com.marcin.jasi.littleandroidapp.photosList.data.entity.PhotoData
import com.marcin.jasi.littleandroidapp.photosList.domain.entity.Photo

class PhotosEntityMapper : DataMapper<PhotoData, Photo>() {

    override fun transform(from: PhotoData): Photo {
        return Photo(from.url, from.id)
    }

}
