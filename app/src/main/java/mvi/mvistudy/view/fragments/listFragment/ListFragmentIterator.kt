package mvi.mvistudy.view.fragments.listFragment

import android.util.Log
import io.reactivex.Single
import io.reactivex.SingleObserver
import mvi.mvistudy.model.domainModel.DataObject
import mvi.mvistudy.model.observers.DisposableCompletableObserver
import mvi.mvistudy.model.observers.OnCompleteActionCallback
import mvi.mvistudy.model.observers.OnSuccessActionCallback
import mvi.mvistudy.model.observers.OnSuccessDisposableSingleObserver
import mvi.mvistudy.useCases.completabeUseCases.DataObjectDeleteUseCase
import mvi.mvistudy.useCases.singleUseCases.DataObjectGetListUseCase

class ListFragmentIterator(private val getListUseCase: DataObjectGetListUseCase,
                           private val deletionUseCase: DataObjectDeleteUseCase) {

        fun processAction(action: ListFragmentAction, resultObserver: SingleObserver<ListFragmentResult>) {
                Log.i("ITERATOR","PROCESSING ACTION")
                when(action){
                        is ListFragmentAction.UpdateList -> updateList(resultObserver)
                        is ListFragmentAction.RemovePosition -> removePosition(action.posId, resultObserver)
                }
        }

        private fun updateList(resultObserver: SingleObserver<ListFragmentResult>) {
                Log.i("ITERATOR","UPDATING")
                getListUseCase.execute(OnSuccessDisposableSingleObserver(object :
                        OnSuccessActionCallback<List<DataObject>> {
                        override fun onSuccessDo(result: List<DataObject>) {
                                resultObserver.onSuccess(ListFragmentResult.Success(result))
                        }
                }))
        }

        private fun removePosition(positionId: Long, resultObserver: SingleObserver<ListFragmentResult>) {
                deletionUseCase.execute(DisposableCompletableObserver(object : OnCompleteActionCallback {
                        override fun onComplete() {
                                resultObserver.onSuccess(ListFragmentResult.Completed)
                        }
                }), positionId)
        }
}