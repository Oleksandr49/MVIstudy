package mvi.mvistudy.view.fragments.listFragment

import mvi.mvistudy.model.domainModel.DataObject

sealed class ListFragmentResult {

    object Completed : ListFragmentResult()
    data class Success(val dataObject: List<DataObject>) : ListFragmentResult()
    data class Error(val errorMessage: String) : ListFragmentResult()
}