package org.mobelitetest.ui.base

import android.support.annotation.StringRes

/**
 * Created by Ali DOUIRI on 09/12/2018.
 * my.alidouiri@gmail.com
 */
interface IView {

    fun showLoading()

    fun hideLoading()

    fun showError(errorMessage: String)

    fun showError(@StringRes errorId: Int)
}