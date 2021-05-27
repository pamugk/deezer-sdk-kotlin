package api.`object`.user

import kotlinx.serialization.Serializable

/**
 * User's Folder
 */
@Serializable
class Folder(
    /**
     * The folder's Deezer id
     */
    val id: Long,
    /**
     * The folder's title
     */
    val title: String
)