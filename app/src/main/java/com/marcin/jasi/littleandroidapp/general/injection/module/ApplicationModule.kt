package com.marcin.jasi.littleandroidapp.general.injection.module

import android.app.Application
import android.content.Context
import com.marcin.jasi.littleandroidapp.details.injection.component.DetailsFragmentComponent
import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerApp
import com.marcin.jasi.littleandroidapp.main.injection.component.MainActivityComponent
import com.marcin.jasi.littleandroidapp.photosList.injection.component.PhotosListFragmentComponent
import dagger.Module
import dagger.Provides


@Module(subcomponents = arrayOf(
        MainActivityComponent::class,
        DetailsFragmentComponent::class,
        PhotosListFragmentComponent::class))
@PerApp
class ApplicationModule {

    @Provides
    @PerApp
    fun provideContext(application: Application): Context {
        return application
    }

}