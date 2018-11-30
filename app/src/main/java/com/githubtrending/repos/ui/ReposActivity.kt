package com.githubtrending.repos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.githubtrending.R
import dagger.android.AndroidInjection
import com.githubtrending.repos.domain.data.NetworkState.*
import com.githubtrending.utils.*
import kotlinx.android.synthetic.main.activity_repos.*

import javax.inject.Inject

class ReposActivity : AppCompatActivity() {

    private lateinit var viewModel: ReposViewModel
    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory

    private lateinit var adapter: RepositoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repos)

        setupRecyclerView()

        setupViewModel()
    }

    private fun setupRecyclerView() {
        adapter = RepositoriesAdapter()
        adapter.repoClickListener = {
            openUrlInWebView(it)
        }
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ReposActivity, RecyclerView.VERTICAL, false)
            addItemDecoration(ListDivider(this@ReposActivity))
            adapter = this@ReposActivity.adapter
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this, viewmodelFactory).get(ReposViewModel::class.java)
        viewModel.repositoriesResult.observe(this, Observer {
            adapter.submitList(it)
        })

        viewModel.repoCount.observe(this, Observer {
            supportActionBar?.subtitle = getString(R.string.repository_results, it.separateThousands())
        })

        viewModel.networkState.observe(this, Observer {
            when (it) {
                ERROR -> {
                    progress.setVisibility(false)
                    parentView.showRetrySnackBar {
                        viewModel.retry()
                    }
                }

                LOADING -> progress.setVisibility(true)
                SUCCESS -> progress.setVisibility(false)
                null -> progress.setVisibility(false)
            }
        })
    }
}

