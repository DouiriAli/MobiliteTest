package org.mobelitetest.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import org.mobelitetest.utils.DialogUtil

/**
 * Created by Ali DOUIRI on 10/12/2018.
 * my.alidouiri@gmail.com
 */
abstract class BaseFragment : Fragment(), IView {

    private var mProgressDialog: ProgressDialog? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    protected abstract fun setUp()


    override fun showLoading() {

        mProgressDialog = activity?.let { DialogUtil.showLoadingDialog(it) }
    }

    override fun hideLoading() {

        if(mProgressDialog?.isShowing!!)
        {
            mProgressDialog?.cancel()
        }

    }

    override fun showError(errorMessage: String) {

        showToast(errorMessage)
    }

    override fun showError(errorId: Int) {

        showToast(getString(errorId))
    }

    private fun showToast(message : String){

        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

}