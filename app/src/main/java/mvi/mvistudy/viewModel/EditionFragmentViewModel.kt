package mvi.mvistudy.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mvi.mvistudy.model.domainModel.DataObject
import mvi.mvistudy.model.observers.DisposableCompletableObserver
import mvi.mvistudy.model.observers.OnCompleteActionCallback
import mvi.mvistudy.model.observers.OnSuccessActionCallback
import mvi.mvistudy.model.observers.OnSuccessDisposableSingleObserver
import mvi.mvistudy.useCases.completabeUseCases.DataObjectUpdateUseCase
import mvi.mvistudy.useCases.singleUseCases.DataObjectDetailsUseCase

class EditionFragmentViewModel (private val detailsUseCase : DataObjectDetailsUseCase, private val updateUseCase : DataObjectUpdateUseCase) : ViewModel() {

    var currentObject : MutableLiveData<DataObject> = MutableLiveData()

    fun saveCurrentObjectState(editedName: String, editedDetails: String){
        currentObject.value?.name = editedName
        currentObject.value?.details = editedDetails
    }

    fun getObject(objectId : Long) {
        detailsUseCase.execute(OnSuccessDisposableSingleObserver(object :
            OnSuccessActionCallback<DataObject> {
            override fun onSuccessDo(`object`: DataObject) {
                currentObject.postValue(`object`)
            }
        }), objectId)
    }

    fun confirmChanges(editedName: String, editedDetails: String){
        val editedObject: DataObject? = currentObject.value
        editedObject?.name = editedName
        editedObject?.details = editedDetails
        if (editedObject != null) {
            updateUseCase.execute(DisposableCompletableObserver(object : OnCompleteActionCallback{
                override fun onComplete() {
                    //working on it
                }

            }), editedObject)
        }
    }

    fun isValid(editedName: String, editedDetails: String) = editedName.isNotEmpty() && editedDetails.isNotEmpty()

    fun disposeUseCase(){
        detailsUseCase.dispose()
        updateUseCase.dispose()
    }

}

