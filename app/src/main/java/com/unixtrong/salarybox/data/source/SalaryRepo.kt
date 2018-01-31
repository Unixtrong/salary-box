package com.unixtrong.salarybox.data.source

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.unixtrong.salarybox.data.SalaryData
import com.unixtrong.salarybox.data.api.SalaryApi
import com.unixtrong.salarybox.tools.debug
import com.unixtrong.salarybox.tools.warn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/** Created by danyun on 2018/1/19 */
class SalaryRepo {
    private val salaryApi = SalaryApi.create()

    companion object {
        private var INSTANCE: SalaryRepo? = null

        fun getInstance() = INSTANCE ?: synchronized(SalaryRepo::class.java) {
            INSTANCE ?: SalaryRepo().also { INSTANCE = it }
        }
    }

    fun calcFinal(origin: String): LiveData<SalaryData> {
        val call = salaryApi.calculate(
                "shanghai",
                origin,
                2000,
                2000,
                true,
                false,
                "0.08")

        val liveData = MutableLiveData<SalaryData>()
        call.enqueue(object : Callback<SalaryData> {
            @SuppressLint("SetTextI18n")
            override fun onFailure(call: Call<SalaryData>?, t: Throwable?) {
                t?.let {
                    warn("onFailure:\n${it.message}")
                    it.warn()
                }
            }

            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<SalaryData>?, response: Response<SalaryData>?) {
                response?.let {
                    debug("onResponse:\n${response.body()}\n===\n${response.errorBody()}")
                    liveData.value = response.body()
                }
            }
        })
        return liveData
    }
}