package com.marcin.jasi.littleandroidapp.general.injection.component

import android.app.Application
import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerApp
import com.marcin.jasi.littleandroidapp.general.injection.module.ActivityBuilder
import com.marcin.jasi.littleandroidapp.general.injection.module.ApplicationModule
import com.marcin.jasi.littleandroidapp.general.injection.module.FragmentBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        FragmentBuilder::class,
        ApplicationModule::class,
        ActivityBuilder::class))
@PerApp
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: com.marcin.jasi.littleandroidapp.Application)
}