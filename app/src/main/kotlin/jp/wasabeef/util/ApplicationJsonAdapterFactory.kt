package jp.wasabeef.util

import com.squareup.moshi.JsonAdapter
import se.ansman.kotshi.KotshiJsonAdapterFactory

/**
 * Created by Wasabeef on 2018/03/06.
 *
 * See <a href="https://github.com/ansman/kotshi">ansman/kotshi</a>
 */
@KotshiJsonAdapterFactory
abstract class ApplicationJsonAdapterFactory : JsonAdapter.Factory {
    companion object {
        val INSTANCE: ApplicationJsonAdapterFactory = KotshiApplicationJsonAdapterFactory()
    }
}