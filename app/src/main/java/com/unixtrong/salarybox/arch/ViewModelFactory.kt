package com.unixtrong.salarybox.arch

import android.arch.lifecycle.ViewModelProvider

/**
 * danyun
 * 2018/1/21
 */
class ViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { ViewModelFactory() }
    }
}