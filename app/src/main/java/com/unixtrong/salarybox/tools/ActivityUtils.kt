package com.unixtrong.salarybox.tools

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/** Created by danyun on 2018/1/17 */
object ActivityUtils {
    fun FragmentManager.addFragment(fragment: Fragment, frameId: Int) {
        val transaction = beginTransaction()
        transaction.add(frameId, fragment)
        transaction.commit()
    }
}