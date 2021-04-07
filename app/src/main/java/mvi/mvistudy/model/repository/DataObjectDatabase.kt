package mvi.mvistudy.model.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import mvi.mvistudy.model.domainModel.DataObject
import mvi.mvistudy.model.repository.DataObjectDAO

@Database(entities = [DataObject::class], version = 1)
abstract class DataObjectDatabase : RoomDatabase() {

    abstract fun dataObjectDAO(): DataObjectDAO

}