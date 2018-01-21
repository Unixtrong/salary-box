package com.unixtrong.salarybox.data.source

import android.annotation.SuppressLint
import com.unixtrong.salarybox.data.SalaryDetails
import com.unixtrong.salarybox.data.api.SalaryApi
import com.unixtrong.salarybox.tools.debug
import com.unixtrong.salarybox.tools.warn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/** Created by danyun on 2018/1/19 */
object SalaryRepo {
    private val salaryApi = SalaryApi.create()

    fun calcFinal(origin: String, callback: (data: SalaryDetails?) -> Unit) {
        val call = salaryApi.calculate(
                "shanghai",
                origin,
                2000,
                2000,
                true,
                false,
                "0.08")

        call.enqueue(object : Callback<SalaryDetails> {
            @SuppressLint("SetTextI18n")
            override fun onFailure(call: Call<SalaryDetails>?, t: Throwable?) {
                t?.let {
                    warn("onFailure:\n${it.message}")
                    it.warn()
                }
            }

            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<SalaryDetails>?, response: Response<SalaryDetails>?) {
                response?.let {
                    debug("onResponse:\n${response.body()}\n===\n${response.errorBody()}")
                    callback.invoke(response.body())
                }
            }
        })
    }
}