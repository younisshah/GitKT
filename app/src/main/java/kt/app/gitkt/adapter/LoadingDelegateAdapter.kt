package kt.app.gitkt.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kt.app.gitkt.R
import kt.app.gitkt.commons.inflate

/**
 * Created by Galileo on 9/9/2016.
 *
 * Loading adapter TODO
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {}

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.repo_loading)) {}
}