package kt.app.gitkt

import kt.app.gitkt.adapter.AdapterConstants
import kt.app.gitkt.adapter.ViewType

/**
 * Created by Galileo on 9/9/2016.
 *
 * Represents a given repo
 * NOTE: only few of the many JSON properties of the incoming JSON object are bound!
 */
data class Repository(
        val avatarURL: String,
        val htmlURL: String,
        val fullName: String,
        val description: String
) : ViewType {
    override fun getViewType() = AdapterConstants.REPO
}