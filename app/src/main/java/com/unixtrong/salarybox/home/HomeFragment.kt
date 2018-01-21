package com.unixtrong.salarybox.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.unixtrong.salarybox.R
import com.unixtrong.salarybox.data.SalaryDetails
import com.unixtrong.salarybox.data.source.SalaryRepo
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/** Created by danyun on 2018/1/17 */
class HomeFragment : Fragment() {

    private var viewModel: HomeViewModel? = null

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = HomeActivity.obtainViewModel(activity)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        etInput.setText("20000")
        btnCalc.setOnClickListener {
            SalaryRepo.calcFinal(etInput.text.toString()) {
                it?.let {

                }
            }
        }
    }
}