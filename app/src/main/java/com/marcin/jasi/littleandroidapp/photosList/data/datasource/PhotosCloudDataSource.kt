package com.marcin.jasi.littleandroidapp.photosList.data.datasource

import com.marcin.jasi.littleandroidapp.photosList.domain.entity.GetPhotosListParams
import com.marcin.jasi.littleandroidapp.photosList.domain.entity.Photo
import io.reactivex.Observable

interface PhotosCloudDataSource {
    fun getPhotosList(params: GetPhotosListParams): Observable<List<Photo>>
}