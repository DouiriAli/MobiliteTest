package org.mobelitetest.ui.post

import android.os.Bundle
import org.mobelitetest.R
import org.mobelitetest.ui.base.BaseActivity


/**
 * Created by Ali DOUIRI on 10/12/2018.
 * my.alidouiri@gmail.com
 */
class PostsActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.posts_activity)
    }

    override fun setUp() {

        switchFragment(PostsFragment.newInstance(), false)
    }
}