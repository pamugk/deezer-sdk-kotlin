package api.`object`.search

import kotlinx.serialization.Serializable

@Serializable
data class AdvancedSearch(
    val artist: String,
    val album: String,
    val track: String,
    val label: String,
    val durMin: Int,
    val durMax: Int,
    val bpmMin: Int,
    val bpmMax: Int
)