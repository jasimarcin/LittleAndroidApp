package com.marcin.jasi.littleandroidapp.details.injection.component

import com.marcin.jasi.littleandroidapp.details.presentation.ui.DetailsFragment
import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerFragment
import com.marcin.jasi.littleandroidapp.general.injection.module.ViewModelBindingModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = arrayOf(/*DetailsFragmentModule::class,*/
        ViewModelBindingModule::class))
@PerFragment
interface DetailsFragmentComponent : AndroidInjector<DetailsFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<DetailsFragment>()

}