package api.`object`.util

fun smallPicture(pictureUrl: String?): String? = pictureWithSize(pictureUrl, "small")
fun mediumPicture(pictureUrl: String?): String? = pictureWithSize(pictureUrl, "medium")
fun bigPicture(pictureUrl: String?): String? = pictureWithSize(pictureUrl, "big")
fun xlPicture(pictureUrl: String?): String? = pictureWithSize(pictureUrl, "xl")
private fun pictureWithSize(pictureUrl: String?, size: String): String? =
    if (pictureUrl == null) null else "$pictureUrl?size=$size"