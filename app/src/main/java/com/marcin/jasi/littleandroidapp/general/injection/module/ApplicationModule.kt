package com.marcin.jasi.littleandroidapp.general.injection.module

import android.app.Application
import android.content.Context
import com.marcin.jasi.littleandroidapp.details.injection.component.DetailsFragmentComponent
import com.marcin.jasi.littleandroidapp.main.injection.component.MainActivityComponent
import dagger.Module
import dagger.Provides


@Module(subcomponents = arrayOf(
        MainActivityComponent :: class
))
class ApplicationModule{

    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

}