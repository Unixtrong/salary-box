package com.unixtrong.salarybox.mock

import android.widget.EditText

/**
 * danyun
 * 2018/1/22
 */
object Injection {
    fun provideSalaryRepo() {

    }

    fun mockInitOriginSalary(etInput: EditText?) {
        etInput?.let {
            it.setText("20000")
            it.setSelection(it.text.length)
        }
    }
}