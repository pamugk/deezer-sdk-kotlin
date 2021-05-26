package api.objects.service

import kotlinx.serialization.Serializable

@Serializable
data class Ad(val start: Int, val interval: Int, val unit: String)