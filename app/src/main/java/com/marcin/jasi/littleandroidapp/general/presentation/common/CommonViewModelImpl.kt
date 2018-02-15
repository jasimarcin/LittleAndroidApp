package com.marcin.jasi.littleandroidapp.general.presentation.common

import io.reactivex.disposables.CompositeDisposable


open class CommonViewModelImpl : CommonViewModel {

    var disposable = CompositeDisposable()

    override fun dispose() {
        if (disposable.isDisposed)
            return

        disposable.dispose()
    }

}


