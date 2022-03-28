package com.zlsp.android.ppsphb.domain.yandex

import android.content.Context
import com.yandex.mobile.ads.banner.BannerAdView
import com.yandex.mobile.ads.interstitial.InterstitialAd

interface YandexAdsRepository {

    fun initYandex(ctx: Context)
    fun initBanner(banner: BannerAdView)
    fun initInterstitial(ctx: Context)
    fun interstitialListener(interstitialAd: InterstitialAd)
    fun bannerListener(banner: BannerAdView)
    fun showInterstitial()
    fun showRewarded(ctx: Context, openLink: ()-> Unit)
}