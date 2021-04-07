package mvi.mvistudy.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mvi.mvistudy.model.domainModel.DataObject
import mvi.mvistudy.model.observers.OnSuccessActionCallback
import mvi.mvistudy.model.observers.OnSuccessDisposableSingleObserver
import mvi.mvistudy.useCases.singleUseCases.DataObjectDetailsUseCase

class DetailsFragmentViewModel(private val useCase : DataObjectDetailsUseCase) : ViewModel() {

    var currentObject : MutableLiveData<DataObject> = MutableLiveData()

    fun getObject(objectId : Long) {
        useCase.execute(OnSuccessDisposableSingleObserver(object :
            OnSuccessActionCallback<DataObject> {
            override fun onSuccessDo(`object`: DataObject) {
                currentObject.postValue(`object`)
            }
        }), objectId)
    }

    fun disposeUseCase(){
        useCase.dispose()
    }
}