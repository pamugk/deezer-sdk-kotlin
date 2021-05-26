package api.objects.search

import api.objects.playables.*
import api.objects.User
import kotlinx.serialization.Serializable

@Serializable
data class FullSearchSet(
    val albumResponse: PartialSearchResponse<Album>?,
    val artistResponse: PartialSearchResponse<Artist>?,
    val playlistResponse: PartialSearchResponse<Playlist>?,
    val radioResponse: PartialSearchResponse<Radio>?,
    val trackResponse: PartialSearchResponse<TrackSearch>?,
    val userResponse: PartialSearchResponse<User>?
)