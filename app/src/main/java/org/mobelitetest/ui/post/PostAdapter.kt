package org.mobelitetest.ui.post

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_post.view.*
import org.mobelitetest.R
import org.mobelitetest.data.model.Post


/**
 * Created by Ali DOUIRI on 09/12/2018.
 * my.alidouiri@gmail.com
 */
class PostAdapter(private var items: List<Post>, private var listener: OnItemClickListener) :
        RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder?.bind(items[position], listener)

    }

    override fun getItemCount(): Int = items?.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val mTitle = itemView.title

        fun bind(item: Post?, listener: OnItemClickListener) {

            mTitle.text = item?.title
            itemView.setOnClickListener { view -> listener.onItemClick(item!!) }
        }

    }

    fun setItems(items: List<Post>) {

        if(items != null && !items?.isEmpty())
        {
            this.items = items
            notifyDataSetChanged()
        }
    }

    interface OnItemClickListener {

        fun onItemClick(item: Post)

    }
}