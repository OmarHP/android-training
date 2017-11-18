package com.example.android.redditlikeproject.posts

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.redditlikeproject.data.entities.Post

/**
 * Created by Aptivist-U001 on 11/13/2017.
 */

class PostsAdapter(var dataSet: List<Post>?): RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return dataSet?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        val viewHolder= ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(dataSet!!.get(position))
    }

    fun updateData(dataSet: List<Post>?){
        this.dataSet = dataSet
        this.notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView: TextView
        init {
            textView = itemView.findViewById(android.R.id.text1)
        }

        fun bind(post: Post){
            textView.setText(post.toString())
        }
    }

}
