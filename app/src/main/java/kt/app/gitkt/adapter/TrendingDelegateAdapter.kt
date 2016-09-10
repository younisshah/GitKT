package kt.app.gitkt.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kotlinx.android.synthetic.main.repo_view.view.*
import kt.app.gitkt.R
import kt.app.gitkt.Repository
import kt.app.gitkt.commons.inflate
import kt.app.gitkt.commons.loadURL

/**
 * Created by Galileo on 9/9/2016.
 *
 * Delegate for a repo view type
 */
class TrendingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TrendingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, repo: ViewType) {
        holder as TrendingViewHolder
        holder.bind(repo as Repository)
    }

    class TrendingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.repo_view)){
        fun bind(repo: Repository) = with(itemView) {
            avatar_img.loadURL(repo.avatarURL)
            full_name.text = repo.fullName
            description.text = repo.description
            url.text = repo.htmlURL
        }
    }
}