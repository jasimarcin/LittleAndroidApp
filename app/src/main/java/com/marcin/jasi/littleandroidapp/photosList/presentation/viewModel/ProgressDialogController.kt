package com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel

import android.databinding.ObservableInt
import android.util.Log
import android.view.View
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.ReplaySubject
import io.reactivex.subjects.Subject
import java.util.concurrent.TimeUnit


class ProgressDialogController {

    companion object {
        val START_PROGRESS = 0
        val END_PROGRESS = 120
        val STEP_PROGRESS = 20
        val PERIOD = 1L
        val UNIT = TimeUnit.SECONDS
    }

    var disposable = CompositeDisposable()
    val callFinish: Subject<Int> = ReplaySubject.create<Int>()
    var progress = ObservableInt(START_PROGRESS)
    var counter = START_PROGRESS

    // I`m sory, but I don`t recomend using AsyncTask :(
    fun startAnimation(): Disposable {
        counter = START_PROGRESS
        refreshCountObservable()
        disposable = CompositeDisposable()

        disposable.add(Observable.interval(PERIOD, UNIT)
                .timeInterval()
                .observeOn(Schedulers.computation())
                .subscribe({ t ->
                    calculateProgres()
                    refreshCountObservable()
                    checkIfNeedFinish()
                }))

        return disposable
    }

    private fun refreshCountObservable() {
        progress.set(counter % END_PROGRESS)
    }

    private fun checkIfNeedFinish() {
        if (counter >= END_PROGRESS)
            callFinish.onNext(counter)
    }

    private fun calculateProgres() {
        counter += STEP_PROGRESS
    }

    fun onCancelClick(): View.OnClickListener = View.OnClickListener { v -> callFinish.onNext(counter) }

    fun onDispose() {
        counter = START_PROGRESS

        if (disposable.isDisposed)
            return

        disposable.dispose()
    }
}