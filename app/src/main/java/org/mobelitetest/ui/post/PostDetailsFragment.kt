package org.mobelitetest.ui.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_postdetails.*
import org.mobelitetest.R
import org.mobelitetest.data.model.Post
import org.mobelitetest.ui.base.BaseFragment
import org.mobelitetest.utils.Constants


/**
 * Created by Ali DOUIRI on 09/12/2018.
 * my.alidouiri@gmail.com
 */
class PostDetailsFragment : BaseFragment() {

    private var mPost : Post?= null

    companion object {

        fun newInstance(post : Post) : PostDetailsFragment{

            val args = Bundle()
            args.putParcelable(Constants.POST_EXTRA, post)
            val fragment = PostDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_postdetails, container, false)
    }

    override fun setUp() {

        if(arguments != null)
        {
            mPost = arguments?.getParcelable(Constants.POST_EXTRA)

            head.text = mPost?.title
            body.text = mPost?.body
        }

    }

}