package jp.wasabeef.data.local

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

/**
 * Created by Wasabeef on 2018/03/05.
 */
@JsonSerializable
data class ApodOfNasa(
        val date: String?,
        val explanation: String?,
        @Json(name = "media_type")
        val mediaType: String?,
        @Json(name = "service_version")
        val version: String?,
        val title: String?,
        val url: String?
)
