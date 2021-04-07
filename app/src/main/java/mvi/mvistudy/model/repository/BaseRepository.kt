package mvi.mvistudy.model.repository

import mvi.mvistudy.model.domainModel.DataObject
import io.reactivex.Completable
import io.reactivex.Single

interface BaseRepository <T> {

    fun getAll(): Single<List<T>>
    fun create(someObject:T) : Single<Long>
    fun update(dataObject: DataObject) : Completable
    fun findById(id:Long) : Single<T>
    fun deleteById(id:Long) : Completable

}