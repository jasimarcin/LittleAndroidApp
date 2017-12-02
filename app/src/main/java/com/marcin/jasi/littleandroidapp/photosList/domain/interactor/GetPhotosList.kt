package com.marcin.jasi.littleandroidapp.photosList.domain.interactor

import com.marcin.jasi.littleandroidapp.general.domain.interactor.UseCase
import com.marcin.jasi.littleandroidapp.photosList.data.repository.PhotosRepository
import com.marcin.jasi.littleandroidapp.photosList.domain.entity.GetPhotosListParams
import com.marcin.jasi.littleandroidapp.photosList.domain.entity.Photo
import io.reactivex.Observable

class GetPhotosList(val repository: PhotosRepository) : UseCase {

    companion object {
        val DOWNLOAD_PACK_SIZE = 20L
    }

    fun getPhotosList(lastDownloadId: Long): Observable<List<Photo>> {
        return repository.getPhotosList(GetPhotosListParams(lastDownloadId, DOWNLOAD_PACK_SIZE))
    }

}