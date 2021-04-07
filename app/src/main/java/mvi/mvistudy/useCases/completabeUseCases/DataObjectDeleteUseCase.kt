package mvi.mvistudy.useCases.completabeUseCases

import mvi.mvistudy.model.repository.DataObjectRepository
import mvi.mvistudy.useCases.baseClasses.CompletableUseCase
import io.reactivex.Completable
import io.reactivex.Scheduler

class DataObjectDeleteUseCase (private val repository: DataObjectRepository, workThread: Scheduler, receivingThread: Scheduler)
    : CompletableUseCase<Long>(workThread, receivingThread)  {

    override fun buildUseCaseCompletable(params: Long): Completable {
        return repository.deleteById(params)
    }
}