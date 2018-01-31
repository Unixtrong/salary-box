package com.unixtrong.salarybox.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.unixtrong.salarybox.R
import com.unixtrong.salarybox.tools.ActivityUtils.addFragment
import com.unixtrong.salarybox.tools.obtainViewModel

class DetailsActivity : AppCompatActivity() {

    private var viewModel: DetailsViewModel? = null

    companion object {
        const val EXTRA_ORIGIN = "ORIGIN_SALARY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setupViewFragment()
        setupViewModel()
    }

    private fun setupViewFragment() {
        val origin = intent.getStringExtra(EXTRA_ORIGIN)
        var fragment = supportFragmentManager.findFragmentById(R.id.flDetails)
        fragment ?: let {
            fragment = DetailsFragment.newInstance(origin)
            supportFragmentManager.addFragment(fragment, R.id.flDetails)
        }
    }

    private fun setupViewModel() {
        viewModel = obtainViewModel(DetailsViewModel::class.java)
    }
}
