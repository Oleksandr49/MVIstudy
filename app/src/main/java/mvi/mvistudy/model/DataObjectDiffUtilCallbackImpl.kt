package mvi.mvistudy.model

import androidx.recyclerview.widget.DiffUtil
import mvi.mvistudy.model.domainModel.DataObject

class DataObjectDiffUtilCallbackImpl(private val oldList: List<DataObject>, private val newList: List<DataObject>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = isSameId(oldList[oldItemPosition], newList[newItemPosition])


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val newObject : DataObject = newList[newItemPosition]
        val oldObject : DataObject = oldList[oldItemPosition]
        return (isSameId(oldObject, newObject) && isSameName(oldObject, newObject) && isSameDetails(oldObject, newObject))
    }

    private fun isSameId(oldObject: DataObject, newObject: DataObject) = (oldObject.id == newObject.id)

    private fun isSameName(oldObject: DataObject, newObject: DataObject) = (oldObject.name == newObject.name)

    private fun isSameDetails(oldObject: DataObject, newObject: DataObject) = (oldObject.details == newObject.details)

}