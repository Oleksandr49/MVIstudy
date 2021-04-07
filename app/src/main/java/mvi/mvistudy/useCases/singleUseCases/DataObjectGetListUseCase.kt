package mvi.mvistudy.useCases.singleUseCases

import mvi.mvistudy.model.domainModel.DataObject
import mvi.mvistudy.model.repository.DataObjectRepository
import mvi.mvistudy.useCases.baseClasses.SingleUseCase
import io.reactivex.Scheduler
import io.reactivex.Single

class DataObjectGetListUseCase  (private val repository: DataObjectRepository, workThread: Scheduler, receivingThread: Scheduler)
    : SingleUseCase<List<DataObject>, Long>(workThread, receivingThread) {

    override fun buildUseCaseSingle(params: Long?): Single<List<DataObject>> {
        return repository.getAll()
    }
}