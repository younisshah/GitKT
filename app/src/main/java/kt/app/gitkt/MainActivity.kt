package kt.app.gitkt

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Galileo on 9/9/2016.
 *
 * Main App KT activity
 **/

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        loadFragment()
    }

    fun loadFragment() {
        val fragmentTXN = supportFragmentManager.beginTransaction()
        fragmentTXN.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit)
        fragmentTXN.replace(R.id.repo_fragment, TrendingFragment())
        fragmentTXN.addToBackStack(null)
        fragmentTXN.commit()
    }
}
