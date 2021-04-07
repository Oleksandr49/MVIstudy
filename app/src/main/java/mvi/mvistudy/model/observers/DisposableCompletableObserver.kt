package mvi.mvistudy.model.observers

import android.util.Log
import io.reactivex.observers.DisposableCompletableObserver

class DisposableCompletableObserver(val actionCallback: OnCompleteActionCallback) : DisposableCompletableObserver() {


    override fun onComplete() {
        actionCallback.onComplete()
    }

    override fun onError(e: Throwable) {
        Log.i("DisposableCompletable", "onError")
    }
}