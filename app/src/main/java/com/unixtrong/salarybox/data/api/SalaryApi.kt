package com.unixtrong.salarybox.data.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/** Created by danyun on 2018/1/17 */
interface SalaryApi {
    @GET("calculate")
    fun calculate(@Query("city") city: String,
                  @Query("origin_salary") origin: String,
                  @Query("base_3j") base3J: Int,
                  @Query("base_gjj") baseFund: Int,
                  @Query("is_gjj") hasFund: Boolean,
                  @Query("is_exgjj") hasExtraFund: Boolean,
                  @Query("factor_exgjj") extraFundFactor: String)

    companion object {
        fun create() = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://salarycalculator.sinaapp.com/")
                .build().create(SalaryApi::class.java)
    }
}