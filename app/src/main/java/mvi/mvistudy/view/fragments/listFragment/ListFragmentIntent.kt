package mvi.mvistudy.view.fragments.listFragment

sealed class ListFragmentIntent {

    object UpdateList : ListFragmentIntent()
    data class RemovePosition(val posId: Long) : ListFragmentIntent()

}