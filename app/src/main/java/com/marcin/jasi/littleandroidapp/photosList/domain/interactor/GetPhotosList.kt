package com.marcin.jasi.littleandroidapp.photosList.domain.interactor

import com.marcin.jasi.littleandroidapp.general.domain.interactor.UseCase
import com.marcin.jasi.littleandroidapp.photosList.data.repository.PhotosRepository
import com.marcin.jasi.littleandroidapp.photosList.domain.entity.GetPhotosListParams
import com.marcin.jasi.littleandroidapp.photosList.domain.entity.Photo
import io.reactivex.Observable

class GetPhotosList(val repository: PhotosRepository) : UseCase {

    companion object {
        val PACK_SIZE = 20L
        val FIRST_PACK_SIZE = 100L
        val FIRST_SIDE = 0
    }

    fun getPhotosList(lastDownloadId: Int): Observable<List<Photo>> {
        return repository.getPhotosList(GetPhotosListParams(lastDownloadId, getPackSize(lastDownloadId)))
    }

    private fun getPackSize(lastDownloadId: Int): Long {
        return if (lastDownloadId == FIRST_SIDE)
            FIRST_PACK_SIZE
        else
            PACK_SIZE
    }

}