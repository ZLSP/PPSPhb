package com.zlsp.android.ppsphb.domain.raports

import android.content.Context

class OpenLinkRaportsItemUseCase(private val rlr: RaportsListRepository) {

    operator fun invoke(ctx: Context, link: String) {
        rlr.openLink(ctx, link)
    }

}