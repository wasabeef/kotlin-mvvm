package jp.wasabeef.data.local.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import jp.wasabeef.BuildConfig

/**
 * Created by Wasabeef on 2018/03/09.
 */
@Database(
        entities = [DeviceEntity::class],
        version = BuildConfig.DB_SCHEMA_VERSION,
        // TODO
        exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract val deviceDao: DeviceDao
}