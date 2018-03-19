package jp.wasabeef

import android.content.Context
import android.support.multidex.MultiDex
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import jp.wasabeef.di.DaggerAppComponent
import jp.wasabeef.di.DatabaseModule
import jp.wasabeef.di.NetworkModule
import timber.log.Timber

/**
 * Created by Wasabeef on 2017/09/27.
 */
open class App : DaggerApplication() {

    lateinit var androidInjector: AndroidInjector<out DaggerApplication>

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
        androidInjector = DaggerAppComponent.builder()
                .application(this)
                .database(databaseModule())
                .network(networkModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initThreeTenABP()
    }

    public override fun applicationInjector(): AndroidInjector<out DaggerApplication> = androidInjector

    protected open fun databaseModule(): DatabaseModule = DatabaseModule()

    protected open fun networkModule(): NetworkModule = NetworkModule()

    protected open fun initTimber() = Timber.plant()

    protected open fun initThreeTenABP() = AndroidThreeTen.init(this)
}