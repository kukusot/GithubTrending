package com.githubtrending.repos.ui

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.githubtrending.R
import com.githubtrending.repos.domain.model.GithubRepository
import com.githubtrending.utils.getTimeAgo
import com.githubtrending.utils.inflate
import com.githubtrending.utils.shortDisplay
import kotlinx.android.synthetic.main.item_repository.view.*

class RepositoriesAdapter :
    PagedListAdapter<GithubRepository, RepositoriesAdapter.RepositoryViewHolder>(BeachesDiffCallback) {

    var repoClickListener: ((repo: GithubRepository?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val itemView = parent.inflate(R.layout.item_repository, false)
        return RepositoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(repo: GithubRepository?) {
            itemView.apply {
                name.text = repo?.fullName
                description.text = repo?.description
                licence.text = repo?.license?.displayName
                language.text = if (repo?.language != null) context.getString(R.string.language, repo.language) else ""
                stars.text = repo?.stars?.shortDisplay()

                val timeAgo = repo?.updatedAt?.getTimeAgo(context)
                val updatedText = if (timeAgo != null) context.getString(R.string.updated, timeAgo) else ""
                updated.text = updatedText
                setOnClickListener {
                    repoClickListener?.invoke(repo)
                }
            }
        }
    }
}

object BeachesDiffCallback : DiffUtil.ItemCallback<GithubRepository>() {

    override fun areItemsTheSame(oldItem: GithubRepository, newItem: GithubRepository) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: GithubRepository, newItem: GithubRepository) = oldItem == newItem
}