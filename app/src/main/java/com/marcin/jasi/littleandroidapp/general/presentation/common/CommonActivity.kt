package com.marcin.jasi.littleandroidapp.general.presentation.common

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


abstract class CommonActivity<T : CommonViewModel> : AppCompatActivity(), HasActivityInjector {

    @Inject
    lateinit var viewModel: T
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    private val disposable: CompositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        bindData()
        initialize()
    }

    abstract fun bindData()

    abstract fun initialize()

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun onDestroy() {
        viewModel.dispose()

        if (!disposable.isDisposed)
            disposable.dispose()

        super.onDestroy()
    }
}
