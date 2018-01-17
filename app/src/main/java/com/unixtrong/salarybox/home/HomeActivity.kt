package com.unixtrong.salarybox.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.unixtrong.salarybox.R
import com.unixtrong.salarybox.tools.ActivityUtils.addFragment

class HomeActivity : AppCompatActivity() {

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
