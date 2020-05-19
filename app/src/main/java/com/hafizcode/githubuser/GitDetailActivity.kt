package com.hafizcode.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_git_detail.*

class GitDetailActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_USER = "detail_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_detail)

        supportActionBar?.title = "Detail User"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val users = intent.getParcelableExtra(DETAIL_USER) as GitUser

        users_photo.setImageResource(users.Avatar)
        name_user.text = users.Name.toString()
        username_github.text = "@${users.Username.toString()}"
        bt1.text = """
            ${users.Repository.toString()}
            Repository
        """.trimIndent()
        bt2.text = """
            ${users.Follower.toString()} 
            Follower
        """.trimIndent()
        bt3.text = """
            ${users.Following.toString()} 
            Following
        """.trimIndent()
        location.text = "Location : ${users.Location.toString()}"
    }
}
