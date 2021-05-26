package api.`object`.search

import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse<T>(val data: List<T>)