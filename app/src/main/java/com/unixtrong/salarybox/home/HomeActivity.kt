package com.unixtrong.salarybox.home

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import com.unixtrong.salarybox.R
import com.unixtrong.salarybox.arch.ViewModelFactory
import com.unixtrong.salarybox.data.source.SalaryRepo
import com.unixtrong.salarybox.tools.ActivityUtils.addFragment

class HomeActivity : AppCompatActivity() {

    companion object {
        fun obtainViewModel(activity: FragmentActivity): HomeViewModel {
            val factory = ViewModelFactory.instance
            return ViewModelProviders.of(activity, factory).get(HomeViewModel::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var homeFragment = supportFragmentManager.findFragmentById(R.id.flHome)
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance()
            supportFragmentManager.addFragment(homeFragment, R.id.flHome)
        }
    }
}
