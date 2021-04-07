package mvi.mvistudy.viewModel

import androidx.lifecycle.ViewModel
import mvi.mvistudy.model.domainModel.DataObject
import mvi.mvistudy.model.observers.EmptyDisposableSingleObserver
import mvi.mvistudy.useCases.singleUseCases.DataObjectCreationSingleUseCase


class CreationFragmentViewModel(private val useCase : DataObjectCreationSingleUseCase) : ViewModel() {

     fun addPosition(name:String, details:String){
            val newPosition = DataObject(name = name, details = details)
            useCase.execute(EmptyDisposableSingleObserver(), newPosition)
    }

    fun isValid(name:String, details: String) = (name.isNotEmpty() && details.isNotEmpty())

    fun disposeUseCase(){
        useCase.dispose()
    }

}