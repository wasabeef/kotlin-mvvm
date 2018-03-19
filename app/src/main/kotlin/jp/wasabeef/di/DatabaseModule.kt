package jp.wasabeef.di

import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import jp.wasabeef.App
import jp.wasabeef.data.local.room.AppDatabase
import jp.wasabeef.data.local.room.DeviceDao
import javax.inject.Singleton

/**
 * Created by Wasabeef on 2018/03/08.
 */
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(app: App): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "wasa.db")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun provideDeviceDao(db: AppDatabase): DeviceDao = db.deviceDao
}