package com.zlsp.android.ppsphb.domain.osnov

data class OsnovItem(
    val id: Int,
    val name: String,
    val article: String,
    val text: String,
    var open: Boolean = DEFAULT_OPEN
) {
    companion object {
        const val DEFAULT_OPEN = false
    }
}
