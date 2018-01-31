package com.unixtrong.salarybox.mock

import android.content.Context
import android.widget.EditText
import com.unixtrong.salarybox.data.source.SalaryRepo

/**
 * danyun
 * 2018/1/22
 */
object Injection {
    fun provideSalaryRepo(context: Context) =
            SalaryRepo.getInstance()

    fun mockInitOriginSalary(etInput: EditText?) {
        etInput?.let {
            it.setText("20000")
            it.setSelection(it.text.length)
        }
    }
}