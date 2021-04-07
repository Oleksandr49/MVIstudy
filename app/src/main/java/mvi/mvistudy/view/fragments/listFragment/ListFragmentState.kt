package mvi.mvistudy.view.fragments.listFragment

import mvi.mvistudy.model.domainModel.DataObject

data class ListFragmentState(val objectsList: List<DataObject> = ArrayList(), val isUpdated: Boolean = false, val errorMessage: String? = null) {
}