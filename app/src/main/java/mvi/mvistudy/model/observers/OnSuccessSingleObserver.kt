package mvi.mvistudy.model.observers

import android.util.Log
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import mvi.mvistudy.view.fragments.listFragment.ListFragmentResult

class OnSuccessSingleObserver<T>(val action: OnSuccessActionCallback<T>) : SingleObserver<T> {
    override fun onSubscribe(d: Disposable) {
        Log.i("Observer", "OnSubscribe")
    }

    override fun onSuccess(t: T) {
        action.onSuccessDo(t)
    }

    override fun onError(e: Throwable) {
        Log.i("Observer", "OnError")
    }
}