package com.zlsp.android.ppsphb.domain.raports

data class RaportsItem(
    val id: Int,
    val name: String,
    val text: String,
    var open: Boolean = DEFAULT_OPEN
) {
    companion object {
        const val DEFAULT_OPEN = false
    }
}
