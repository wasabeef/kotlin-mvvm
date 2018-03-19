package jp.wasabeef.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import jp.wasabeef.App
import jp.wasabeef.BuildConfig.HTTPS
import jp.wasabeef.BuildConfig.NASA_ENDPOINT
import jp.wasabeef.data.remote.PlanetService
import jp.wasabeef.di.Qualifiers.NASA
import jp.wasabeef.util.ApplicationJsonAdapterFactory
import jp.wasabeef.util.InstantAdapter
import jp.wasabeef.util.Memory
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Wasabeef on 2017/10/16.
 */
@Module
open class NetworkModule {

    open fun buildOkHttpClient(app: App): OkHttpClient =
            OkHttpClient.Builder()
                    .connectTimeout(10L, TimeUnit.SECONDS)
                    .writeTimeout(10L, TimeUnit.SECONDS)
                    .readTimeout(30L, TimeUnit.SECONDS)
                    .cache(Cache(File(app.cacheDir, "OkCache"),
                            Memory.calcCacheSize(app, .25f)))
                    .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(app: App): OkHttpClient = buildOkHttpClient(app)

    @Singleton
    @Provides
    fun provideMoshi() = Moshi.Builder()
            .add(ApplicationJsonAdapterFactory.INSTANCE)
            .add(InstantAdapter.INSTANCE)
            .build()

    @Provides
    @Singleton
    @Named(NASA)
    fun provideRetrofitForNasa(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
            .baseUrl("$HTTPS://$NASA_ENDPOINT")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providePlanetService(@Named(NASA) retrofit: Retrofit): PlanetService =
            retrofit.create(PlanetService::class.java)
}