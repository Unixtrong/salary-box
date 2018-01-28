package com.unixtrong.salarybox.details

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.unixtrong.salarybox.R
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.coroutines.experimental.async

/**
 * danyun
 * 2018/1/28
 */
class DetailsFragment : Fragment() {
    private var viewModel: DetailsViewModel? = null

    companion object {
        const val ARG_ORIGIN = "ORIGIN_SALARY"
        fun newInstance(origin: String): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = Bundle().apply { putString(ARG_ORIGIN, origin) }
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        viewModel = DetailsActivity.obtainViewModel(activity)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadData()
        viewModel?.calc(arguments.getString(ARG_ORIGIN))
    }

    private fun loadData() {
        if (arguments != null) {
            tvTest.text = arguments.getString(ARG_ORIGIN)
        } else {
            tvTest.text = "null arg"
        }
    }
}