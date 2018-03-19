package jp.wasabeef.data.remote

import javax.inject.Inject

/**
 * Created by Wasabeef on 2018/03/05.
 */
class PlanetDataSource @Inject constructor(private val planetService: PlanetService) {
    fun getInfo() = planetService.getInfo("DEMO_KEY")
}