package api.objects.search

import kotlinx.serialization.Serializable

@Serializable
data class PartialSearchResponse<T>(
    val data: List<T>, val total: Int,
    val prev: String?, val next: String?) {

    fun hasPrev(): Boolean {
        return prev != null
    }

    fun hasNext(): Boolean {
        return next != null
    }
}