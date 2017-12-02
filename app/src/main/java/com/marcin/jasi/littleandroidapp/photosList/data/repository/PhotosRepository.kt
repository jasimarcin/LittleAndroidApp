package com.marcin.jasi.littleandroidapp.photosList.data.repository

import com.marcin.jasi.littleandroidapp.photosList.data.datasource.PhotosCloudDataSource
import com.marcin.jasi.littleandroidapp.photosList.domain.entity.GetPhotosListParams
import com.marcin.jasi.littleandroidapp.photosList.domain.entity.Photo
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class PhotosRepository(val cloudDataSource: PhotosCloudDataSource) {

    fun getPhotosList(params: GetPhotosListParams): Observable<List<Photo>> {
        // simulation backend
        return cloudDataSource.getPhotosList(params).delay(3, TimeUnit.SECONDS)
    }

}