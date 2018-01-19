package com.unixtrong.salarybox.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.unixtrong.salarybox.R
import com.unixtrong.salarybox.data.source.SalaryRepo
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/** Created by danyun on 2018/1/17 */
class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnCalc.setOnClickListener {
            val call = SalaryRepo.calcFinal(etInput.text.toString())
            call.enqueue(object : Callback<String> {
                @SuppressLint("SetTextI18n")
                override fun onFailure(call: Call<String>?, t: Throwable?) {
                    t?.let {
                        etInput.setText("onFailure:\n${it.message}")
                        it.printStackTrace()
                    }
                }

                @SuppressLint("SetTextI18n")
                override fun onResponse(call: Call<String>?, response: Response<String>?) {
                    response?.let {
                        etInput.setText("onResponse:\n${response.body()}\n===\n${response.errorBody()}")
                    }
                }
            })
        }
    }
}