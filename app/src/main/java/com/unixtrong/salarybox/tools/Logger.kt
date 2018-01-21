package com.unixtrong.salarybox.tools

import android.util.Log

/**
 * danyun
 * 2018/1/21
 */

const val TAG = "hs"

fun debug(msg: String) {
    Log.d(TAG, msg)
}

fun info(msg: String) {
    Log.i(TAG, msg)
}

fun warn(msg: String) {
    Log.w(TAG, msg)
}

fun error(msg: String) {
    Log.e(TAG, msg)
}

fun Throwable.warn() {
    Log.w(TAG, this)
}