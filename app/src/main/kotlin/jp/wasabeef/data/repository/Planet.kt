package jp.wasabeef.data.repository

import io.reactivex.Flowable
import jp.wasabeef.data.local.ApodOfNasa

/**
 * Created by Wasabeef on 2018/03/05.
 */
interface Planet {
    fun getInfo(): Flowable<ApodOfNasa>
}