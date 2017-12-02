package com.marcin.jasi.littleandroidapp.general.injection.module

import android.app.Application
import android.content.Context
import com.marcin.jasi.littleandroidapp.details.injection.component.DetailsFragmentComponent
import com.marcin.jasi.littleandroidapp.general.presentation.helper.ColorGenerator
import com.marcin.jasi.littleandroidapp.main.injection.component.MainActivityComponent
import com.marcin.jasi.littleandroidapp.photosList.injection.component.PhotosListFragmentComponent
import dagger.Module
import dagger.Provides


@Module(subcomponents = arrayOf(
        MainActivityComponent::class,
        DetailsFragmentComponent::class,
        PhotosListFragmentComponent::class))
class ApplicationModule {

    @Provides
    fun provideContext(application: Application): Context = application

    @Provides
    fun provideColorGenerator(context: Context): ColorGenerator = ColorGenerator(context)

}