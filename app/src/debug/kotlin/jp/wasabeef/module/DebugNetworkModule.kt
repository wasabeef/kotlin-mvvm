package jp.wasabeef.module

import jp.wasabeef.App
import jp.wasabeef.di.NetworkModule
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by Wasabeef on 2017/10/19.
 */
@Module
class DebugNetworkModule : NetworkModule() {

    override fun buildOkHttpClient(app: App): OkHttpClient =
            super.buildOkHttpClient(app).newBuilder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.HEADERS
                    })
                    .addNetworkInterceptor(StethoInterceptor())
                    .build()
}