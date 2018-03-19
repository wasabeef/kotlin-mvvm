package jp.wasabeef.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import jp.wasabeef.ui.main.home.HomeViewModel

/**
 * Created by Wasabeef on 2018/03/05.
 */
@Module(includes = [RepositoryModule::class])
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

//    @Binds
//    @IntoMap
//    @ViewModelKey(DeviceViewModel::class)
//    fun bindDeviceViewModel(viewModel: DeviceViewModel): ViewModel

//    @Binds
//    @IntoMap
//    @ViewModelKey(MainViewModel::class)
//    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}