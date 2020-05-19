package com.hafizcode.githubuser

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: GitUserAdapter

    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataAvatar: TypedArray
    private lateinit var dataCompany: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowing: Array<String>

    private var gitusers = arrayListOf<GitUser>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = GitUserAdapter(this)
        listViewItemGitUser.divider = null
        listViewItemGitUser.adapter = adapter

        prepare()
        addItem()

        listViewItemGitUser.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val moveGitUser = GitUser(
                    gitusers[position].Username,
                    gitusers[position].Name,
                    gitusers[position].Avatar,
                    gitusers[position].Company,
                    gitusers[position].Location,
                    gitusers[position].Repository,
                    gitusers[position].Follower,
                    gitusers[position].Following
                )

                val moveIntentToDetail = Intent(this@MainActivity, GitDetailActivity::class.java)
                moveIntentToDetail.putExtra(GitDetailActivity.DETAIL_USER, moveGitUser)
                startActivity(moveIntentToDetail)
            }
    }


    private fun prepare() {
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataCompany = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataFollower = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val gituser = GitUser(
                dataUsername[position],
                dataName[position],
                dataAvatar.getResourceId(position, -1),
                dataCompany[position],
                dataLocation[position],
                dataRepository[position],
                dataFollower[position],
                dataFollowing[position]
            )
            gitusers.add(gituser)
        }
        adapter.gitusers = gitusers
    }
}
