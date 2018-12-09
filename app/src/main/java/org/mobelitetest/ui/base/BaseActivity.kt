package org.mobelitetest.ui.base

import android.app.ProgressDialog
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import org.mobelitetest.utils.DialogUtil


/**
 * Created by Ali DOUIRI on 09/12/2018.
 * my.alidouiri@gmail.com
 */
open abstract class BaseActivity : AppCompatActivity(), IView {

    private var mProgressDialog: ProgressDialog? = null

    override fun showLoading() {

        hideLoading()
        mProgressDialog = DialogUtil.showLoadingDialog(this)
    }

    override fun hideLoading() {

        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog?.cancel()
        }

    }

    override fun showError(errorMessage: String) {

        Snackbar.make(findViewById(android.R.id.content), errorMessage, Snackbar.LENGTH_LONG)
                .show()

    }

    override fun showError(errorId: Int) {

        Snackbar.make(findViewById(android.R.id.content), getString(errorId), Snackbar.LENGTH_LONG)
                .show()
    }

    protected abstract fun setUp()
}