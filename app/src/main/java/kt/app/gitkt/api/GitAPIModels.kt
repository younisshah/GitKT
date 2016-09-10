package kt.app.gitkt.api

/**
 * Created by Galileo on 10/9/2016.
 *
 * Merged: GitRepositoryItem class, GitRepositoryItemResponse class, GitRepositoryItems class
 * and GitRepositoryItemsResponse class here!!!
 */

class GitRepositoryItems(
        val full_name: String,
        val owner: GitRepositoryOwner,
        val html_url: String,
        val description: String
)

class GitRepositoryOwnerResponse(val owner: GitRepositoryOwner)

class GitRepositoryOwner (
        val avatar_url : String
)
