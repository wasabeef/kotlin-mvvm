package jp.wasabeef

import jp.wasabeef.module.DebugNetworkModule
import jp.wasabeef.di.NetworkModule
import com.facebook.stetho.Stetho
import com.facebook.stetho.timber.StethoTree
import timber.log.Timber

/**
 * Created by Wasabeef on 2017/10/17.
 */
class DebugApp : App() {

    override fun onCreate() {
        super.onCreate()
        initStetho()
    }

    override fun networkModule(): NetworkModule = DebugNetworkModule()

    override fun initTimber() {
        Timber.plant(Timber.DebugTree())
        Timber.plant(StethoTree())
    }

    fun initStetho() = Stetho.initializeWithDefaults(this)
}