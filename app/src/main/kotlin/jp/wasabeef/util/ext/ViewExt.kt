package jp.wasabeef.util.ext

import android.view.View

/**
 * Viewの汎用的な拡張関数
 * Created by Wasabeef on 2017/10/02.
 */
fun View.toVisible() {
    visibility = View.VISIBLE
}

fun View.toInvisible() {
    visibility = View.INVISIBLE
}

fun View.toGone() {
    visibility = View.GONE
}