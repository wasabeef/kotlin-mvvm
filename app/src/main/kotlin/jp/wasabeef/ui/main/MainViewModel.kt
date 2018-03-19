package jp.wasabeef.ui.main

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Wasabeef on 2018/03/02.
 */
class MainViewModel : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}