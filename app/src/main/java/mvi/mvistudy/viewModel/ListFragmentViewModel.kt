package mvi.mvistudy.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mvi.mvistudy.model.observers.OnSuccessSingleObserver
import mvi.mvistudy.model.observers.OnSuccessActionCallback
import mvi.mvistudy.view.fragments.listFragment.*


class ListFragmentViewModel (val iterator: ListFragmentIterator) : ViewModel() {

    var currentState : MutableLiveData<ListFragmentState> = MutableLiveData()

    private val resultReceiver = OnSuccessSingleObserver(object: OnSuccessActionCallback<ListFragmentResult>{
        override fun onSuccessDo(result: ListFragmentResult) {
            processResult(result)
        }
    })

    private fun processResult(result: ListFragmentResult){
        Log.i("VM","PROCESSING RESULT")
                when(result){
                    is ListFragmentResult.Success -> currentState.postValue(ListFragmentState(result.dataObject, true))
                    is ListFragmentResult.Error -> currentState.postValue(ListFragmentState(errorMessage = result.errorMessage))
                    is ListFragmentResult.Completed -> currentState.postValue(ListFragmentState(isUpdated = false))
                }
    }

    fun processIntent(intent: ListFragmentIntent) {
        Log.i("VM","GOT INTENT")
            when (intent) {
                is ListFragmentIntent.UpdateList -> iterator.processAction(ListFragmentAction.UpdateList, resultReceiver)

                is ListFragmentIntent.RemovePosition -> iterator.processAction(ListFragmentAction.RemovePosition(intent.posId), resultReceiver)
            }
    }
}