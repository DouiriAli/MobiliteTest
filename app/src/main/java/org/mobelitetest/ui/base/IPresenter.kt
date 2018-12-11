package org.mobelitetest.ui.base


/**
 * Created by Ali DOUIRI on 09/12/2018.
 * my.alidouiri@gmail.com
 */
interface IPresenter<in V : IView> {

    fun attachView(view: V)

    fun detachView()

    fun isViewAttached(): Boolean
}