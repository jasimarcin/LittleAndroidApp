package com.marcin.jasi.littleandroidapp

import android.app.Activity
import android.app.Application
import android.app.Fragment
import com.marcin.jasi.littleandroidapp.general.injection.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject


class Application : Application(), HasActivityInjector, HasFragmentInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector;
    }

    override fun fragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingFragmentInjector;
    }

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }
}