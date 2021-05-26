package api.`object`.service

import kotlinx.serialization.Serializable

@Serializable
data class Offer(
    val id: Long,
    val name: String,
    val amount: Float,
    val currency: String,
    val displayedAmount: String,
    val tc: String,
    val tcHtml: String,
    val tcTxt: String,
    val tryAndBuy: Int
)