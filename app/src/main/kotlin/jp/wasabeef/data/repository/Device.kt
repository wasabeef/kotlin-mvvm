package jp.wasabeef.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import jp.wasabeef.data.local.room.DeviceEntity

/**
 * Created by Wasabeef on 2018/03/09.
 */
interface Device {
    fun save(device: DeviceEntity): Completable
    fun get(): Single<DeviceEntity>
}