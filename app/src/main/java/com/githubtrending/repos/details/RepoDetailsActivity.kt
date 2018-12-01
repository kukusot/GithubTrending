package com.githubtrending.repos.details

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.githubtrending.R
import com.githubtrending.core.di.GlideApp
import com.githubtrending.repos.domain.model.GithubRepository
import com.githubtrending.repos.ui.REPO_KEY
import com.githubtrending.utils.openUrlInWebView
import kotlinx.android.synthetic.main.activity_details.*

class RepoDetailsActivity : AppCompatActivity() {

    private lateinit var repository: GithubRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val repo = intent.getParcelableExtra<GithubRepository?>(REPO_KEY)
        if (repo == null) {
            Toast.makeText(this, R.string.error, Toast.LENGTH_LONG).show()
            return
        }
        repository = repo
        setupUi()
    }

    private fun setupUi() {
        with(repository) {
            supportActionBar?.title = name
            GlideApp.with(this@RepoDetailsActivity).load(owner.avatarUrl).into(ownerLogo)
            ownerName.text = owner.login
            descriptionText.text = description
            starsText.text = repository.stars.toString()
            forksText.text = repository.forksCount.toString()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_details, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.link) {
            openUrlInWebView(repository.htmlUrl)
            return true
        }
        return false
    }

}