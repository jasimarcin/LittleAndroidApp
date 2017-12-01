package com.marcin.jasi.littleandroidapp.photosList.injection.component

import com.marcin.jasi.littleandroidapp.general.injection.module.ViewModelBindingModule
import com.marcin.jasi.littleandroidapp.photosList.injection.module.PhotosListModule
import com.marcin.jasi.littleandroidapp.photosList.presentation.ui.PhotosListFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = arrayOf(PhotosListModule::class,
        ViewModelBindingModule::class))
interface PhotosListComponent : AndroidInjector<PhotosListFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<PhotosListFragment>()

}