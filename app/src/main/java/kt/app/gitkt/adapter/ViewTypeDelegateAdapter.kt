package kt.app.gitkt.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by Galileo on 9/9/2016.
 *
 * TODO
 */
interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, repo: ViewType)
}