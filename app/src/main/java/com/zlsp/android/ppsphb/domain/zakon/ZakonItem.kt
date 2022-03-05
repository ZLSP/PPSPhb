package com.zlsp.android.ppsphb.domain.zakon

data class ZakonItem(
    val id: Int,
    val article: String,
    val text1: String,
    val text2: String = DEFAULT_TEXT_2,
    val header: String = DEFAULT_HEADER,
    var active: Boolean = DEFAULT_ACTIVE_STATE
) {
    companion object {
        const val DEFAULT_ACTIVE_STATE = false
        const val DEFAULT_TEXT_2 = ""
        const val DEFAULT_HEADER = "Федеральный закон от 07.02.2011 N 3-ФЗ (ред. от 21.12.2021)" +
                " \"О полиции\""
    }
}
