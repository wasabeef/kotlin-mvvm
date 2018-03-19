package jp.wasabeef.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import jp.wasabeef.data.local.room.AppDatabase
import jp.wasabeef.data.local.room.DeviceDao
import jp.wasabeef.data.local.room.DeviceEntity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Wasabeef on 2018/03/09.
 */
@Singleton
class DeviceRepository @Inject constructor(
        private val database: AppDatabase,
        private val dao: DeviceDao
) : Device {
    override fun save(device: DeviceEntity): Completable {

        return Completable.create({
            database.runInTransaction { dao.save(device) }
            it.onComplete()
        })
    }

    override fun get(): Single<DeviceEntity> = dao.get()
}