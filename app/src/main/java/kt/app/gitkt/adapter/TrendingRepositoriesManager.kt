package kt.app.gitkt.adapter

import kt.app.gitkt.Repository
import kt.app.gitkt.api.GitAPIKTClient
import rx.Observable

/**
 * Created by Galileo on 10/9/2016.
 *
 * TrendingRepositoriesManager - Responsible for obtaining the Git repos
 */
class TrendingRepositoriesManager(val gitAPI : GitAPIKTClient = GitAPIKTClient()) {

    fun getTrendingRepositories() : Observable<List<Repository>> {
        return Observable.create {
            subscriber ->
                val repositories = mutableListOf<Repository>()
                val call = gitAPI.getTrending("1")
                val response = call.execute()

                if(response.isSuccessful) {
                    response.body().forEach {
                        val _r = Repository(
                                it.owner.avatar_url,
                                it.html_url,
                                it.full_name,
                                it.description
                        )

                        repositories.add(_r)
                    }
                    subscriber.onNext(repositories)
                    subscriber.onCompleted()
                } else {
                    subscriber.onError(Throwable(response.message()))
                }
        }
    }
}