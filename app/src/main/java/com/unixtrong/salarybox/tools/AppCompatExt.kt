package com.unixtrong.salarybox.tools

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import com.unixtrong.salarybox.arch.ViewModelFactory

/** Created by danyun on 2018/1/31 */
fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>): T {
    val factory = ViewModelFactory.getInstance(application)
    return ViewModelProviders.of(this, factory).get(viewModelClass)
}