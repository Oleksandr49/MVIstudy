package mvi.mvistudy.model.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import mvi.mvistudy.model.domainModel.DataObject
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface DataObjectDAO {

    @Query("SELECT * FROM DataObjects")
    fun getAll(): Single<List<DataObject>>

    @Query("SELECT * FROM DataObjects WHERE id = :id")
    fun findById(id: Long): Single<DataObject>

    @Insert
    fun create(dataObject: DataObject): Single<Long>

    @Update
    fun update(dataObject: DataObject) : Completable

    @Query("DELETE FROM DataObjects WHERE id = :id")
    fun deleteById(id: Long): Completable
}