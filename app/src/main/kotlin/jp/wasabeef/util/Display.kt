package jp.wasabeef.util

import android.view.View
import android.view.Window

/**
 * Created by Wasabeef on 2017/10/23.
 */
class Display {
    companion object {
        fun showSystemUi(window: Window) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        }
    }
}