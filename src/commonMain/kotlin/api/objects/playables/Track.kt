package api.objects.playables

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Track(
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
    val album: Album,
    val unseen: Boolean,
    val isrc: String,
    val trackPosition: Int,
    val diskNumber: Int,
    val releaseDate: LocalDate,
    val explicitContentLyrics: Int,
    val explicitContentCover: Int,
    val bpm: Float,
    val gain: Float,
    val availableCountries: List<String>,
    val alternative: Track?,
    val contributors: List<Artist>?
)