package mvi.mvistudy.useCases.singleUseCases

import mvi.mvistudy.model.domainModel.DataObject
import mvi.mvistudy.model.repository.DataObjectRepository
import mvi.mvistudy.useCases.baseClasses.SingleUseCase
import io.reactivex.Scheduler
import io.reactivex.Single

class DataObjectDetailsUseCase (private val repository: DataObjectRepository, workThread: Scheduler, receivingThread: Scheduler)
    : SingleUseCase<DataObject, Long>(workThread, receivingThread) {

    override fun buildUseCaseSingle(params: Long?): Single<DataObject> {
        return params?.let { repository.findById(it) }!!
    }

}