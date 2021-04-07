package mvi.mvistudy.useCases.baseClasses

import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableCompletableObserver

abstract class CompletableUseCase <in Params>(private val workThread: Scheduler, private val receivingThread: Scheduler) : BaseUseCase(workThread, receivingThread){

    abstract fun buildUseCaseCompletable(params: Params): Completable

    fun execute(observer: DisposableCompletableObserver, params: Params) {
        val completable = buildUseCaseCompletableWithSchedulers(params)
        addDisposable(completable.subscribeWith(observer))
    }

    private fun buildUseCaseCompletableWithSchedulers(params: Params): Completable {
        return buildUseCaseCompletable(params)
            .subscribeOn(workThread)
            .observeOn(receivingThread)
    }
}