package mvi.mvistudy.useCases.singleUseCases

import mvi.mvistudy.model.domainModel.DataObject
import mvi.mvistudy.model.repository.DataObjectRepository
import mvi.mvistudy.useCases.baseClasses.SingleUseCase
import io.reactivex.Scheduler
import io.reactivex.Single

class DataObjectCreationSingleUseCase(private val repository: DataObjectRepository, workThread: Scheduler, receivingThread: Scheduler)
    : SingleUseCase<Long, DataObject>(workThread, receivingThread) {

    override fun buildUseCaseSingle(params: DataObject?): Single <Long> {
            return params?.let { repository.create(it) }!!
    }
}