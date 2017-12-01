package com.marcin.jasi.littleandroidapp.general.injection.module

import android.app.Fragment
import com.marcin.jasi.littleandroidapp.details.injection.component.DetailsFragmentComponent
import com.marcin.jasi.littleandroidapp.details.presentation.ui.DetailsFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.FragmentKey
import dagger.multibindings.IntoMap

@Module
abstract class FragmentBuilder {

    @Binds
    @IntoMap
    @FragmentKey(DetailsFragment::class)
    abstract fun bindDetailsFragment(builder: DetailsFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>

}