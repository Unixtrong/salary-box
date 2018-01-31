package com.unixtrong.salarybox.arch

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.annotation.VisibleForTesting
import com.unixtrong.salarybox.data.source.SalaryRepo
import com.unixtrong.salarybox.details.DetailsViewModel
import com.unixtrong.salarybox.home.HomeViewModel
import com.unixtrong.salarybox.mock.Injection

/**
 * danyun
 * 2018/1/21
 */
class ViewModelFactory private constructor(
        private val app: Application,
        private val salaryRepo: SalaryRepo
) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(app: Application) = INSTANCE ?: synchronized(ViewModelFactory::class.java) {
            INSTANCE ?: ViewModelFactory(app,
                    Injection.provideSalaryRepo(app.applicationContext)).also { INSTANCE = it }
        }

        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = with(modelClass) {
        when {
            isAssignableFrom(HomeViewModel::class.java) ->
                    HomeViewModel(app, salaryRepo)
            isAssignableFrom(DetailsViewModel::class.java) ->
                    DetailsViewModel(app, salaryRepo)
            else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}