package com.unixtrong.salarybox.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.unixtrong.salarybox.arch.SingleLiveEvent
import com.unixtrong.salarybox.data.source.SalaryRepo

/**
 * danyun
 * 2018/1/22
 */
class HomeViewModel(app: Application, salaryRepo: SalaryRepo) : AndroidViewModel(app) {
    val openDetailsEvent = SingleLiveEvent<String>()
}