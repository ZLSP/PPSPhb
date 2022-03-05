package com.zlsp.android.ppsphb.domain.polnomoch

data class PolnomochItem(
    val id: Int,
    val name: String,
    val text: String,
    var open: Boolean = DEFAULT_OPEN
) {
    companion object {
        const val DEFAULT_OPEN = false
    }
}
