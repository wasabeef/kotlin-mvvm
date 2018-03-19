package jp.wasabeef.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.wasabeef.ui.main.home.HomeFragment

/**
 * Created by Wasabeef on 2017/10/17.
 */
@Module
internal abstract class MainModule {
    @ContributesAndroidInjector
    internal abstract fun contributeTopFragmentInjector(): HomeFragment
}