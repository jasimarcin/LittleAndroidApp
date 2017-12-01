package com.marcin.jasi.littleandroidapp.details.injection.module

import android.app.Activity
import com.marcin.jasi.littleandroidapp.general.presentation.helper.Navigator
import dagger.Module
import dagger.Provides

@Module
class DetailsFragmentModule {

    @Provides
    fun provideNavigator(activity : Activity): Navigator {
        return Navigator(activity)
    }

}