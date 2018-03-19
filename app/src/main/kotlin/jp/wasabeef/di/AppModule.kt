package jp.wasabeef.di

import dagger.Module

/**
 * Created by Wasabeef on 2017/10/16.
 */
@Module(includes = [DatabaseModule::class, NetworkModule::class, ViewModelModule::class])
internal object AppModule {
    // If you need.
}
