package com.unixtrong.salarybox.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.unixtrong.salarybox.arch.SingleLiveEvent

/**
 * danyun
 * 2018/1/22
 */
class HomeViewModel(app: Application) : AndroidViewModel(app) {
    val openDetailsEvent = SingleLiveEvent<String>()
}