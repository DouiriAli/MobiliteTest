package org.mobelitetest.ui.post

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.mobelitetest.data.model.Post
import org.mobelitetest.data.remote.RemoteService
import org.mobelitetest.ui.base.BasePresenter

/**
 * Created by Ali DOUIRI on 09/12/2018.
 * my.alidouiri@gmail.com
 */
class PostPresenter(val remoteService : RemoteService) : BasePresenter<PostContract.PostContractView>(), PostContract.PostContractPresenter {

    private val TAG = PostPresenter::class.java.simpleName

    override fun getPosts() {

        getView()?.showLoading()

        remoteService.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response ->

                            if (!isViewAttached()) return@subscribe

                            getView()?.hideLoading()

                            if (response.isSuccessful) {
                                getView()?.onPostsReady(response.body()!!)
                            }

                        },
                        { error ->
                            getView()?.hideLoading();Log.e(TAG, "{$error.message}")
                        },
                        {
                            getView()?.hideLoading()
                            Log.d(TAG, "completed")
                        })

    }

    override fun navigatePostDetails(post: Post) {

        getView()?.navigatePostDetails(post)
    }


}