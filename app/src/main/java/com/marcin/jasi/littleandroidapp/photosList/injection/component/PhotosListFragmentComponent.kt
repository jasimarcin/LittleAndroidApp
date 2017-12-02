package com.marcin.jasi.littleandroidapp.photosList.injection.component

import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerFragment
import com.marcin.jasi.littleandroidapp.general.injection.module.ViewModelBindingModule
import com.marcin.jasi.littleandroidapp.photosList.injection.module.PhotosListFragmentModule
import com.marcin.jasi.littleandroidapp.photosList.presentation.ui.PhotosListFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = arrayOf(PhotosListFragmentModule::class,
        ViewModelBindingModule::class))
@PerFragment
interface PhotosListFragmentComponent : AndroidInjector<PhotosListFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<PhotosListFragment>()

}