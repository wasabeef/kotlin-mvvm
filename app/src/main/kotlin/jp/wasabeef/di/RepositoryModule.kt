package jp.wasabeef.di

import dagger.Binds
import dagger.Module
import jp.wasabeef.data.repository.Device
import jp.wasabeef.data.repository.DeviceRepository
import jp.wasabeef.data.repository.Planet
import jp.wasabeef.data.repository.PlanetRepository

/**
 * Created by Wasabeef on 2018/03/05.
 */
@Module
interface RepositoryModule {
    @Binds
    fun bindPlanetRepository(repository: PlanetRepository): Planet

    @Binds
    fun bindDeviceRepository(repository: DeviceRepository): Device
}