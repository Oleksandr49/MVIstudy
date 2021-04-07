package mvi.mvistudy.view.fragments.listFragment

sealed class ListFragmentAction {

    object UpdateList : ListFragmentAction()
    data class RemovePosition(val posId: Long) : ListFragmentAction()

}