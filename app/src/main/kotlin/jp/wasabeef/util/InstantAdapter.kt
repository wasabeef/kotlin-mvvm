package jp.wasabeef.util

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import org.threeten.bp.Instant
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter.ISO_INSTANT

/**
 * Created by Wasabeef on 2018/03/06.
 *
 * See <a href="https://github.com/square/moshi/">square/moshi</a>
 */
class InstantAdapter {

    companion object {
        val INSTANCE = InstantAdapter()
    }

    @ToJson
    fun toJson(time: Instant): String = ISO_INSTANT.format(time)

    @FromJson
    fun fromJson(time: String): Instant =
            ISO_INSTANT.parse(time, Instant.FROM).atZone(ZoneId.systemDefault()).toInstant()
}