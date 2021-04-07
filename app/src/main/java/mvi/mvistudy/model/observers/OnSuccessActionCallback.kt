package mvi.mvistudy.model.observers

interface OnSuccessActionCallback<T> {
    fun onSuccessDo(result: T)
}