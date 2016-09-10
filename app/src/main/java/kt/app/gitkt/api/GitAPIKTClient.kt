package kt.app.gitkt.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Galileo on 10/9/2016.
 *
 * REST Client for GitHub
 */
class GitAPIKTClient {

    val gitAPI : GitAPI

    init {
        val retrofit = Retrofit
                            .Builder()
                            .baseUrl("https://api.github.com/search/")
                            .addConverterFactory(MoshiConverterFactory.create())
                            .build()

        gitAPI = retrofit.create(GitAPI::class.java)
    }

    fun getTrending(page : String) : Call<List<GitRepositoryItems>> {
        return gitAPI.getTrending(page)
    }
}