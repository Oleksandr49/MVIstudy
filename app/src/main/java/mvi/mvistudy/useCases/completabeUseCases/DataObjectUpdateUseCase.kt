package mvi.mvistudy.useCases.completabeUseCases

import mvi.mvistudy.model.domainModel.DataObject
import mvi.mvistudy.model.repository.DataObjectRepository
import mvi.mvistudy.useCases.baseClasses.CompletableUseCase
import io.reactivex.Completable
import io.reactivex.Scheduler

class DataObjectUpdateUseCase (private val repository: DataObjectRepository, workThread: Scheduler, receivingThread: Scheduler)
    : CompletableUseCase<DataObject>(workThread, receivingThread) {

    override fun buildUseCaseCompletable(params: DataObject): Completable {
        return repository.update(params)
    }
}