package com.marcin.jasi.littleandroidapp.main.injection.component

import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerActivity
import com.marcin.jasi.littleandroidapp.general.injection.module.ViewModelBindingModule
import com.marcin.jasi.littleandroidapp.main.injection.module.MainActivityModule
import com.marcin.jasi.littleandroidapp.main.presentation.ui.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = arrayOf(MainActivityModule::class,
        ViewModelBindingModule::class))
@PerActivity
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()

}