package mvi.mvistudy.view.fragments.listFragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import mvi.mvistudy.R
import mvi.mvistudy.model.DataObjectDiffUtilCallbackImpl
import mvi.mvistudy.model.domainModel.DataObject

class ListFragmentAdapter : RecyclerView.Adapter<ViewHolder>() {

    private var itemsList : List<DataObject> = ArrayList()
    lateinit var viewCallback : ViewCallback


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.objectName.text = itemsList[position].name
        holder.objectName.setOnClickListener {
            itemsList[holder.adapterPosition].id?.let { id -> viewCallback.positionDetails(id) }
        }
        holder.removeButton.setOnClickListener {
            itemsList[holder.adapterPosition].id?.let { id -> viewCallback.removePosition(id) }
        }
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    fun updateList(updatedList: List<DataObject>){
        val result = DiffUtil.calculateDiff(DataObjectDiffUtilCallbackImpl(itemsList, updatedList))
        itemsList = updatedList
        result.dispatchUpdatesTo(this)
    }



}