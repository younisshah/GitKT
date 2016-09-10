package kt.app.gitkt


import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_trending.*
import kt.app.gitkt.adapter.TrendingRepositoriesAdapter
import kt.app.gitkt.adapter.TrendingRepositoriesManager
import kt.app.gitkt.commons.inflate
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * Created by Galileo on 9/9/2016.
 *
 * Trending Git Repositories Fragment!!
 */
class TrendingFragment : Fragment() {

    private val trendingRepositoriesManager by lazy { TrendingRepositoriesManager() }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        /**
         * Using Extension function here.
         * Extended ViewGroup with inflate()
         */
        return container?.inflate(R.layout.fragment_trending)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        trending_list.setHasFixedSize(true)
        trending_list.layoutManager = LinearLayoutManager(context)

        if(trending_list.adapter == null) {
            trending_list.adapter = TrendingRepositoriesAdapter()
        }

        getRepositories()
    }

    private fun getRepositories() {
        /*val observable =*/ trendingRepositoriesManager
                                .getTrendingRepositories()
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(
                                    {
                                        _repositories -> (trending_list.adapter as TrendingRepositoriesAdapter).addRepos(_repositories)
                                    },
                                    {
                                        e -> Snackbar.make(trending_list, e.message ?: "", Snackbar.LENGTH_LONG).show()
                                    }
                                )

    }
}
