package com.marcin.jasi.littleandroidapp.photosList.injection.module

import android.telecom.PhoneAccount
import com.marcin.jasi.littleandroidapp.general.domain.mapper.DataMapper
import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerFragment
import com.marcin.jasi.littleandroidapp.general.presentation.helper.DialogHelper
import com.marcin.jasi.littleandroidapp.photosList.data.datasource.PhotosCloudDataSource
import com.marcin.jasi.littleandroidapp.photosList.data.datasource.PhotosCloudDataSourceMockImpl
import com.marcin.jasi.littleandroidapp.photosList.data.entity.PhotoData
import com.marcin.jasi.littleandroidapp.photosList.data.repository.PhotosRepository
import com.marcin.jasi.littleandroidapp.photosList.domain.entity.Photo
import com.marcin.jasi.littleandroidapp.photosList.domain.interactor.GetPhotosList
import com.marcin.jasi.littleandroidapp.photosList.domain.entity.mapper.PhotosEntityMapper
import com.marcin.jasi.littleandroidapp.photosList.domain.entity.mapper.PhotosViewModelMapper
import com.marcin.jasi.littleandroidapp.photosList.presentation.adapter.PhotosListAdapter
import com.marcin.jasi.littleandroidapp.photosList.presentation.ui.PhotosListFragment
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.PhotosListItemViewModel
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.ProgressDialogController
import dagger.Module
import dagger.Provides

@Module
@PerFragment
class PhotosListFragmentModule {

    @Provides
    @PerFragment
    fun provideDialogHelper(fragment: PhotosListFragment): DialogHelper = DialogHelper(fragment.activity)

    @Provides
    @PerFragment
    fun provideProgressDialogController(): ProgressDialogController = ProgressDialogController()

    @Provides
    @PerFragment
    fun providePhotosViewModelEntityMapper(): DataMapper<Photo, PhotosListItemViewModel> = PhotosViewModelMapper()

    @Provides
    @PerFragment
    fun providePhotosEntityMapper(): DataMapper<PhotoData, Photo> = PhotosEntityMapper()

    @Provides
    @PerFragment
    fun providePhotosCloudDataSource(mapper: DataMapper<PhotoData, Photo>): PhotosCloudDataSource = PhotosCloudDataSourceMockImpl(mapper)

    @Provides
    @PerFragment
    fun providePhotosRepository(cloudDataSource: PhotosCloudDataSource): PhotosRepository = PhotosRepository(cloudDataSource)


    @Provides
    @PerFragment
    fun provideGetPhotosList(repository: PhotosRepository): GetPhotosList = GetPhotosList(repository)

    @Provides
    @PerFragment
    fun providePhotosListAdapter(): PhotosListAdapter = PhotosListAdapter()

}