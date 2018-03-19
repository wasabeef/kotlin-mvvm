package jp.wasabeef.data.remote

import io.reactivex.Flowable
import jp.wasabeef.data.local.ApodOfNasa
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Wasabeef on 2018/03/05.
 */
interface PlanetService {
    @GET("/planetary/apod")
    fun getInfo(@Query("api_key") key: String): Flowable<ApodOfNasa>
}