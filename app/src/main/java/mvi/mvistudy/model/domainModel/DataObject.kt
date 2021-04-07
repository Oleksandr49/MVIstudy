package mvi.mvistudy.model.domainModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DataObjects")
data class DataObject(@PrimaryKey(autoGenerate = true) var id : Long? = null,
                      @ColumnInfo(name = "name")var name: String,
                      @ColumnInfo(name = "details")var details: String)
