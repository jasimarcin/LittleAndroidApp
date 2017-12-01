package com.marcin.jasi.littleandroidapp.general.injection.module

import android.app.Activity
import com.marcin.jasi.littleandroidapp.details.injection.component.DetailsFragmentComponent
import com.marcin.jasi.littleandroidapp.details.presentation.ui.DetailsFragment
import com.marcin.jasi.littleandroidapp.main.injection.component.MainActivityComponent
import com.marcin.jasi.littleandroidapp.main.presentation.ui.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindMainMenuActivity(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>

}