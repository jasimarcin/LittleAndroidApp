package com.marcin.jasi.littleandroidapp.photosList.data.datasource

import com.marcin.jasi.littleandroidapp.general.domain.mapper.DataMapper
import com.marcin.jasi.littleandroidapp.photosList.data.entity.PhotoData
import com.marcin.jasi.littleandroidapp.photosList.domain.entity.GetPhotosListParams
import com.marcin.jasi.littleandroidapp.photosList.domain.entity.Photo
import io.reactivex.Observable

// Class created for mock backend responses
class PhotosCloudDataSourceMockImpl(var mapper: DataMapper<PhotoData, Photo>) : PhotosCloudDataSource {

    companion object {
        val MAX_DATA = 200
    }

    // backend simulation
    override fun getPhotosList(params: GetPhotosListParams): Observable<List<Photo>> {
        return Observable.create({ emiter ->

            var data = ArrayList<PhotoData>()

            for (number in params.lastId..(params.amount + params.lastId - 1))
                if (number <= MAX_DATA)
                    data.add(getPhotoObject(number))

            emiter.onNext(mapper.transform(data))
            emiter.onComplete()
        })

    }

    fun getPhotoObject(number: Long): PhotoData {
        var dataSet = number % 3

        var url = when (dataSet) {
            0L -> "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/PM5544_with_non-PAL_signals.png/384px-PM5544_with_non-PAL_signals.png"
            1L -> "https://www.bjrnet.com/images/test/Testing_in_Progress.gif"
            else -> "https://media.giphy.com/media/IHHzf3XSDzKec/giphy.gif"
        }

        return PhotoData(url, number)
    }
}