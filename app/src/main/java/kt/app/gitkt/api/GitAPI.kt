package kt.app.gitkt.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Galileo on 10/9/2016.
 *
 * GitHub Repo API
 */
interface GitAPI {
    @GET("/repositories?q=any&sort=stars&order=desc&per_page=10")
    fun getTrending(@Query("page")page : String) : Call<List<GitRepositoryItems>>
}