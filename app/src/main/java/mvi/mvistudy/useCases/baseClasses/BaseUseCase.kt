package mvi.mvistudy.useCases.baseClasses

import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseUseCase(workThread: Scheduler, receivingThread: Scheduler) {

    protected val threadExecutorScheduler: Scheduler = workThread

    protected val postExecutionThreadScheduler: Scheduler = receivingThread

    private val disposables = CompositeDisposable()

    open fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    protected fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}