package jp.wasabeef.util

import timber.log.Timber

/**
 * Created by Wasabeef on 2018/03/05.
 */
fun defaultErrorHandler(): (Throwable) -> Unit = { e -> Timber.e(e) }