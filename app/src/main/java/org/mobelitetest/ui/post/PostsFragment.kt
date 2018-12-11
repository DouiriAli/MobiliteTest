package org.mobelitetest.ui.post

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_posts.*
import org.mobelitetest.PostsApp
import org.mobelitetest.R
import org.mobelitetest.data.model.Post
import org.mobelitetest.ui.base.BaseActivity
import org.mobelitetest.ui.base.BaseFragment
import javax.inject.Inject


/**
 * Created by Ali DOUIRI on 09/12/2018.
 * my.alidouiri@gmail.com
 */
class PostsFragment : BaseFragment(), PostContract.PostContractView, PostAdapter.OnItemClickListener {

    private var mAdapter: PostAdapter? = null

    @Inject
    lateinit var mPresenter: PostPresenter

    companion object {

        fun newInstance() : PostsFragment{

            return PostsFragment()
        }
    }

    init {

        PostsApp.getPostComponent()?.inject(this)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mPresenter.attachView(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_posts, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.getPosts()

    }

    override fun setUp() {

        mAdapter = PostAdapter(ArrayList<Post>(), this)
        val mLayoutManager = LinearLayoutManager(activity)
        recyclerview.layoutManager = mLayoutManager
        recyclerview.addItemDecoration(DividerItemDecoration(activity, LinearLayoutManager.VERTICAL))
        recyclerview.adapter = mAdapter

    }

    override fun onPostsReady(items: List<Post>) {

        mAdapter?.setItems(items)

    }

    override fun onItemClick(item : Post) {

        mPresenter.navigatePostDetails(item)

    }

    override fun navigatePostDetails(post: Post) {

        (activity as BaseActivity).switchFragment(PostDetailsFragment.newInstance(post), true)

    }

    override fun onDestroy() {

        mPresenter?.detachView()
        super.onDestroy()
    }

}