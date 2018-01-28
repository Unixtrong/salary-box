package com.unixtrong.salarybox.data

/** Created by danyun on 2018/1/19 */
data class SalaryData(
        val origin_salary: String,
        val percent_factor_exgjj: String,
        val base_3j: String,
        val base_gjj: String,
        val personal_yanglao: String,
        val personal_yiliao: String,
        val personal_shiye: String,
        val org_yanglao: String,
        val org_yiliao: String,
        val org_shiye: String,
        val org_shengyu: String,
        val org_gongshang: String,
        val personal_gjj: String,
        val org_gjj: String,
        val personal_exgjj: String,
        val org_exgjj: String,
        val personal_allpay: String,
        val org_allpay: String,
        val before_tax: String,
        val tax: String,
        val final_salary: String
)