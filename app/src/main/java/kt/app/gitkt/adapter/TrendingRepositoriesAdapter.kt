package kt.app.gitkt.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kt.app.gitkt.Repository
import java.util.*

/**
 * Created by Galileo on 9/9/2016.
 *
 * Adapter - TODO
 */
class TrendingRepositoriesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var repositories: ArrayList<ViewType>
    private var delegates = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }

    init {
        delegates.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegates.put(AdapterConstants.REPO, TrendingDelegateAdapter())
        repositories = ArrayList()
        repositories.add(loadingItem)
    }

    override fun getItemViewType(position: Int): Int {
        return this.repositories[position].getViewType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegates.get(viewType).onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegates.get(getItemViewType(position)).onBindViewHolder(holder, this.repositories[position])
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    fun addMockRepos(_repositories: List<Repository>) {
        val initPosition = repositories.size - 1
        repositories.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        repositories.addAll(_repositories)
        repositories.add(loadingItem)
        notifyItemRangeChanged(initPosition, repositories.size + 1)
    }

}