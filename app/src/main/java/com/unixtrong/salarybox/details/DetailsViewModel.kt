package com.unixtrong.salarybox.details

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.unixtrong.salarybox.data.SalaryData
import com.unixtrong.salarybox.data.source.SalaryRepo

/**
 * danyun
 * 2018/1/28
 */
class DetailsViewModel(
        app: Application,
        private val salaryRepo: SalaryRepo
) : AndroidViewModel(app) {

    private var liveData: LiveData<SalaryData>? = null

    fun calc(origin: String): LiveData<SalaryData>? {
        liveData = salaryRepo.calcFinal(origin)
        return liveData
    }
}