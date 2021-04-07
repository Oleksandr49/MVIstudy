package mvi.mvistudy.view.fragments.listFragment.adapter

interface ViewCallback {
    fun removePosition(positionID: Long)
    fun positionDetails(positionID: Long)
}