package kt.app.gitkt


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_trending.*
import kt.app.gitkt.adapter.TrendingRepositoriesAdapter
import kt.app.gitkt.commons.inflate


/**
 * Created by Galileo on 9/9/2016.
 *
 * Trending Git Repositories Fragment!!
 */
class TrendingFragment : Fragment() {

   /* private val trendingList by lazy {
        *//**
         * trending_list is actually a view property - the ID of RecyclerView.
         * In Kotlin, it's a synthetic property
         * defined in fragment_trending.xml
         * Using Kotlin android extensions, we don't have to use 'findViewByID()' anymore
         * Just use the view ID and yuo are done!! :)
         *//*
        trending_list
        trending_list.setHasFixedSize(true)
        trending_list.layoutManager = LinearLayoutManager(context)
    }*/

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
        trending_list.adapter = TrendingRepositoriesAdapter()

        val repositories = mutableListOf<Repository>()
        for (i in 1..10) {
            repositories.add(Repository(
                    "http://lorempixel.com/200/200/technics/$i",
                    "https://youtu.be",
                    "User $i",
                    "This is description # $i",
                    "$i",
                    "Kotlin"
            ))
        }
        println(repositories)
        (trending_list.adapter as TrendingRepositoriesAdapter).addMockRepos(repositories)
    }
}
