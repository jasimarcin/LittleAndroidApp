package com.marcin.jasi.littleandroidapp.general.presentation.common

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class CommonFragment<T : CommonViewModel> : Fragment(), HasFragmentInjector {

    @Inject
    lateinit var viewModel: T
    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    val disposable: CompositeDisposable = CompositeDisposable()


    override fun fragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        AndroidInjection.inject(this)
        bindData(inflater!!, container)
        initialize()
        return getRootView()
    }

    abstract fun bindData(inflater: LayoutInflater, container: ViewGroup?)

    abstract fun getRootView(): View

    abstract fun initialize()

    override fun onDestroy() {
        if (!disposable.isDisposed)
            disposable.dispose()

        super.onDestroy()
    }
}