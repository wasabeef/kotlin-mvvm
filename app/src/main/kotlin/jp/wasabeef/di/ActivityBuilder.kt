package jp.wasabeef.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.wasabeef.ui.main.MainActivity

/**
 * Created by Wasabeef on 2017/10/16.
 */
@Module
internal abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributeMainInjector(): MainActivity
}