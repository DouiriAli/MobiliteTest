package org.mobelitetest.ui.base

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import org.mobelitetest.R


/**
 * Created by Ali DOUIRI on 11/12/2018.
 * my.alidouiri@gmail.com
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onResume() {
        super.onResume()
        setUp()
    }

    protected abstract fun setUp()

    fun switchFragment(mFragment: Fragment, mStack: Boolean) {

        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.content, mFragment, mFragment.javaClass.name.toString())

        if (mStack)
            transaction.addToBackStack(mFragment.javaClass.name.toString())

        transaction.commit()
    }
}