package jp.wasabeef.ui.main.home

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import jp.wasabeef.data.local.ApodOfNasa
import jp.wasabeef.data.repository.Planet
import jp.wasabeef.util.Result
import jp.wasabeef.util.defaultErrorHandler
import jp.wasabeef.util.ext.toLiveData
import javax.inject.Inject

/**
 * Created by Wasabeef on 2018/03/02.
 */
class HomeViewModel @Inject constructor(
        private val planetRepository: Planet
) : ViewModel(), LifecycleObserver {

    private val disposable: CompositeDisposable = CompositeDisposable()

    val planet: LiveData<Result<ApodOfNasa>> by lazy {
        planetRepository.getInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { Result.success(it) }
                .doOnError(defaultErrorHandler())
                .onErrorReturn { Result.failure(it) }
                .startWith(Result.loading())
                .toLiveData()
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}