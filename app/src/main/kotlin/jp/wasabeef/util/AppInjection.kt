package jp.wasabeef.util

import android.content.Context
import jp.wasabeef.App
import jp.wasabeef.di.AppComponent

/**
 * Created by Wasabeef on 2017/10/26.
 */
object AppInjection {
    fun of(context: Context?): AppComponent {
        return (context as App).applicationInjector() as AppComponent
    }
}