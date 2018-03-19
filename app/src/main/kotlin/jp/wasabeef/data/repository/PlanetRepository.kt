package jp.wasabeef.data.repository

import io.reactivex.Flowable
import jp.wasabeef.data.local.ApodOfNasa
import jp.wasabeef.data.remote.PlanetDataSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Wasabeef on 2018/03/05.
 */
@Singleton
class PlanetRepository @Inject constructor(
        private val planetDataSource: PlanetDataSource
) : Planet {

    override fun getInfo(): Flowable<ApodOfNasa> {
        return planetDataSource.getInfo()
    }
}