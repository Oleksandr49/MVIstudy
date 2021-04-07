package mvi.mvistudy.model.observers

import android.util.Log
import io.reactivex.observers.DisposableSingleObserver

class EmptyDisposableSingleObserver<T> : DisposableSingleObserver<T>() {

    override fun onSuccess(t: T) {
        Log.i("EmptyDisposableSingle", "OnSuccess")
    }

    override fun onError(e: Throwable) {
        Log.i("EmptyDisposableSingle", "OnComplete")
    }
}