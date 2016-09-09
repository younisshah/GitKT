@file:JvmName("Extensions")

package kt.app.gitkt.commons

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kt.app.gitkt.R

/**
 * Created by Galileo on 9/9/2016.
 *
 * Extensions Functions
 */

fun ViewGroup.inflate(layoutIdD: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutIdD, this, attachToRoot)
}

fun ImageView.loadURL(url : String) {
    if(TextUtils.isEmpty(url)) {
        Picasso.with(context).load(R.drawable.avatar).into(this)
    }
    else {
        Picasso.with(context).load(url).into(this)
    }
}