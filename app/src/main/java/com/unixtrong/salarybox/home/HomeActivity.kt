package com.unixtrong.salarybox.home

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.unixtrong.salarybox.R
import com.unixtrong.salarybox.details.DetailsActivity
import com.unixtrong.salarybox.tools.ActivityUtils.addFragment
import com.unixtrong.salarybox.tools.obtainViewModel

class HomeActivity : AppCompatActivity(), HomeNavigator {
    private var viewModel: HomeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initWindow()
        // arch.1 实例化当前页的 fragment
        setupViewFragment()
        // arch.2 实例化当前页的 viewModel，并实现其中的事件
        setupViewModel()
    }

    private fun setupViewFragment() {
        var homeFragment = supportFragmentManager.findFragmentById(R.id.flHome)
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance()
            supportFragmentManager.addFragment(homeFragment, R.id.flHome)
        }
    }

    private fun setupViewModel() {
        viewModel = obtainViewModel(HomeViewModel::class.java)
        viewModel?.openDetailsEvent?.observe(this, Observer {
            it?.let { openDetails(it) }
        })
    }

    private fun initWindow() {
        // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        //     window.statusBarColor = Color.TRANSPARENT
        //     window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        // }
    }

    override fun openDetails(origin: String) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.EXTRA_ORIGIN, origin)
        startActivity(intent)
    }
}
