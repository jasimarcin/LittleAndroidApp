package com.marcin.jasi.littleandroidapp.photosList.injection.module

import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerFragment
import com.marcin.jasi.littleandroidapp.general.presentation.helper.DialogHelper
import com.marcin.jasi.littleandroidapp.photosList.presentation.ui.PhotosListFragment
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
}