package com.unixtrong.salarybox.data.source

import com.unixtrong.salarybox.data.api.SalaryApi

/** Created by danyun on 2018/1/19 */
object SalaryRepo {
    private val salaryApi = SalaryApi.create()

    fun calcFinal(origin: String) = salaryApi.calculate(
            "shanghai", origin, 2000, 2000,
            true, false, "0.08")
}