package api.objects.playables

import kotlinx.serialization.Serializable

@Serializable
data class TrackSearch(
    val id: Long, val type: String,
    val link: String, val share: String,
    val readable: Boolean,
    val title: String,
    val titleShort: String,
    val titleVersion: String,
    val duration: Int,
    val rank: Int,
    val explicitLyrics: Boolean,
    val preview: String,
    val artist: Artist,
    val album: Album
)