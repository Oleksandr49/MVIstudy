package mvi.mvistudy.useCases.baseClasses

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver

abstract class SingleUseCase <Results, in Params>(private val workThread: Scheduler, private val receivingThread: Scheduler)
    : BaseUseCase(workThread, receivingThread) {

    abstract fun buildUseCaseSingle(params:Params? = null): Single<Results>

    fun execute(observer: DisposableSingleObserver<Results>, params:Params? = null) {
        if(params != null){
            val single = buildUseCaseSingleWithSchedulers(params)
            addDisposable(single.subscribeWith(observer))
        }
        else{
            val single = buildUseCaseSingleWithSchedulers()
            addDisposable(single.subscribeWith(observer))
        }
    }

    private fun buildUseCaseSingleWithSchedulers(params:Params? = null): Single<Results> {
        return if(params != null){
            buildUseCaseSingle(params)
                    .subscribeOn(workThread)
                    .observeOn(receivingThread)
        }
        else{
            buildUseCaseSingle()
                    .subscribeOn(workThread)
                    .observeOn(receivingThread)
        }
    }
}
