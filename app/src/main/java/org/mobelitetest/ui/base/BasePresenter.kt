package org.mobelitetest.ui.base

/**
 * Created by Ali DOUIRI on 09/12/2018.
 * my.alidouiri@gmail.com
 */
open class BasePresenter<V : IView> : IPresenter<V> {

    private var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {

        if (mView != null) mView = null
    }

    override fun isViewAttached(): Boolean {
        return mView != null
    }

    fun getView(): V? {
        return mView
    }

    fun checkViewAttached() {
        if (!isViewAttached()) throw ViewNotAttachedException()
    }

    class ViewNotAttachedException : RuntimeException("View not attached to presenter")
}