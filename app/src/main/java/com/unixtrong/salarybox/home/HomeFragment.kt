package com.unixtrong.salarybox.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.unixtrong.salarybox.R
import com.unixtrong.salarybox.mock.Injection
import kotlinx.android.synthetic.main.fragment_home.*

/** Created by danyun on 2018/1/17 */
class HomeFragment : Fragment() {

    private var viewModel: HomeViewModel? = null

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        viewModel = HomeActivity.obtainViewModel(activity)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Injection.mockInitOriginSalary(etInput)
        btnCalc.setOnClickListener {
            viewModel?.openDetailsEvent?.setValue(etInput.text.toString())
        }
    }
}