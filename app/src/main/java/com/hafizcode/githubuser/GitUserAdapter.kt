package com.hafizcode.githubuser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.github_hero.view.*

class GitUserAdapter constructor(private val context: Context) : BaseAdapter() {

    var gitusers = arrayListOf<GitUser>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.github_hero, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val gituser = getItem(position) as GitUser
        viewHolder.bind(gituser)
        return itemView
    }

    private inner class ViewHolder constructor(private val view: View) {
        fun bind(gitUser: GitUser) {
            with(view) {
                name_github.text = gitUser.Name
                username_github.text = "@" + gitUser.Username
                repository.text = gitUser.Repository + " Repository"
                follow.text = gitUser.Follower+ " Followers " + gitUser.Following + " Following"
                img_user_github.setImageResource(gitUser.Avatar)
            }
        }
    }

    override fun getItem(position: Int): Any {
        return gitusers[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return gitusers.size
    }
}