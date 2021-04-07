package mvi.mvistudy.model.observers

import android.util.Log
import io.reactivex.observers.DisposableSingleObserver

class OnSuccessDisposableSingleObserver<T>(private val onSuccessAction : OnSuccessActionCallback<T>) : DisposableSingleObserver<T>() {


    override fun onSuccess(t: T) {
        onSuccessAction.onSuccessDo(t)
    }

    override fun onError(e: Throwable) {
        Log.i("Error", e.message.toString())
    }

}