package kt.app.gitkt.adapter

import kt.app.gitkt.Repository
import rx.Observable

/**
 * Created by Galileo on 10/9/2016.
 *
 * TrendingRepositoriesManager - Responsible for obtaining the Git repos
 */
class TrendingRepositoriesManager {

    fun getTrendingRepositories() : Observable<List<Repository>> {
        return Observable.create {
            subscriber ->
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
            subscriber.onNext(repositories)
            //subscriber.onCompleted()
        }
    }
}