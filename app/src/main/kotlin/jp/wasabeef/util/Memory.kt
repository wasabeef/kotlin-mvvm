package jp.wasabeef.util

import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import android.content.pm.ApplicationInfo.FLAG_LARGE_HEAP
import android.support.annotation.FloatRange

/**
 * Created by Wasabeef on 2017/10/16.
 */
object Memory {

    /**
     * 指定された百分率をメモリから計算する
     */
    fun calcCacheSize(context: Context, @FloatRange(from = 0.01, to = 1.0) size: Float): Long {
        val am = context.getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val largeHeap = context.applicationInfo.flags and FLAG_LARGE_HEAP != 0
        val memoryClass = if (largeHeap) am.largeMemoryClass else am.memoryClass
        return (memoryClass * 1024L * 1024L * size).toLong()
    }
}