package mvi.mvistudy.model.repository

import mvi.mvistudy.model.domainModel.DataObject
import io.reactivex.Completable
import io.reactivex.Single

class DataObjectRepository(private val dataObjectDAO: DataObjectDAO): BaseRepository<DataObject> {

    override fun getAll(): Single<List<DataObject>> = dataObjectDAO.getAll()

    override fun create(someObject: DataObject) : Single<Long> = dataObjectDAO.create(someObject)

    override fun findById(id: Long): Single<DataObject> = dataObjectDAO.findById(id)

    override fun deleteById(id: Long) : Completable = dataObjectDAO.deleteById(id)

    override fun update(dataObject: DataObject) : Completable = dataObjectDAO.update(dataObject)
}