package org.mobelitetest.ui.post

import org.mobelitetest.data.model.Post
import org.mobelitetest.ui.base.IView


/**
 * Created by Ali DOUIRI on 09/12/2018.
 * my.alidouiri@gmail.com
 */
interface PostContract {

    interface PostContractPresenter {

        fun getPosts()

        fun navigatePostDetails(post: Post)

    }

    interface PostContractView : IView {

        fun onPostsReady(items: List<Post>)

        fun navigatePostDetails(post : Post)

    }
}