package com.zlsp.android.ppsphb.data.ads

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.banner.BannerAdEventListener
import com.yandex.mobile.ads.banner.BannerAdView
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import com.yandex.mobile.ads.common.MobileAds
import com.yandex.mobile.ads.interstitial.InterstitialAd
import com.yandex.mobile.ads.interstitial.InterstitialAdEventListener
import com.yandex.mobile.ads.rewarded.Reward
import com.yandex.mobile.ads.rewarded.RewardedAd
import com.yandex.mobile.ads.rewarded.RewardedAdEventListener
import com.zlsp.android.ppsphb.domain.yandex.YandexAdsRepository

object YandexAdsRepositoryImpl: YandexAdsRepository {
    
    private const val YANDEX_MOBILE_ADS_TAG = "YandexMobileAds"

    private const val YANDEX_BANNER_TAG = "YandexBanner"
    private const val YANDEX_BANNER_ID = "R-M-1579265-1"

    private const val YANDEX_INTERSTITIAL_TAG = "YandexInterstitial"
    private const val YANDEX_INTERSTITIAL_ID = "R-M-1579265-3"
    private const val YANDEX_INTERSTITIAL_ID_DEMO = "R-M-DEMO-320x480"

    const val YANDEX_REWARDED_TAG = "YandexRewarded"
    const val YANDEX_REWARDED_ID = "R-M-1579265-4"
    private const val YANDEX_REWARDED_ID_DEMO = "R-M-DEMO-rewarded-client-side-rtb"

    val adRequest = AdRequest.Builder().build()
    private lateinit var interstitialAd: InterstitialAd
    private lateinit var rewardedAd: RewardedAd
    
    override fun initYandex(ctx: Context) {
        MobileAds.initialize(ctx
        ) { Log.d(YANDEX_MOBILE_ADS_TAG, "SDK initialized") }
    }

    override fun initBanner(banner: BannerAdView) {
        bannerListener(banner)
        banner.apply {
            setAdSize(AdSize.BANNER_320x50)
            setAdUnitId(YANDEX_BANNER_ID)
            loadAd(adRequest)
        }
    }

    override fun bannerListener(banner: BannerAdView) {
        banner.setBannerAdEventListener(object : BannerAdEventListener {
            override fun onAdLoaded() {
                Log.d(YANDEX_BANNER_TAG,"onAdLoaded")
            }

            override fun onAdFailedToLoad(p0: AdRequestError) {
                Log.d(YANDEX_BANNER_TAG,"onAdFailedToLoad")
            }

            override fun onAdClicked() {
                Log.d(YANDEX_BANNER_TAG,"onAdClicked")
            }

            override fun onLeftApplication() {
                Log.d(YANDEX_BANNER_TAG,"onLeftApplication")
            }

            override fun onReturnedToApplication() {
                Log.d(YANDEX_BANNER_TAG,"onReturnedToApplication")
            }

            override fun onImpression(p0: ImpressionData?) {
                Log.d(YANDEX_BANNER_TAG,"onImpression: ${p0.toString()}")
            }

        })
    }

    override fun showInterstitial(ctx: Context) {
        interstitialAd = InterstitialAd(ctx)
        interstitialAd.setAdUnitId(YANDEX_INTERSTITIAL_ID)
        interstitialAd.setInterstitialAdEventListener(object : InterstitialAdEventListener {
            override fun onAdLoaded() {
                Log.d(YANDEX_INTERSTITIAL_TAG,"onAdLoaded")
                interstitialAd.show()
            }

            override fun onAdFailedToLoad(p0: AdRequestError) {
                Log.d(YANDEX_INTERSTITIAL_TAG,"onAdFailedToLoad: ${p0.description}")
            }

            override fun onAdShown() {
                Log.d(YANDEX_INTERSTITIAL_TAG,"onAdShown")
            }

            override fun onAdDismissed() {
                Log.d(YANDEX_INTERSTITIAL_TAG,"onAdDismissed")
            }

            override fun onAdClicked() {
                Log.d(YANDEX_INTERSTITIAL_TAG,"onAdClicked")
            }

            override fun onLeftApplication() {
                Log.d(YANDEX_INTERSTITIAL_TAG,"onLeftApplication")
            }

            override fun onReturnedToApplication() {
                Log.d(YANDEX_INTERSTITIAL_TAG,"onReturnedToApplication")
            }

            override fun onImpression(p0: ImpressionData?) {
                Log.d(YANDEX_INTERSTITIAL_TAG,"onImpression: ${p0.toString()}")
            }

        })
        interstitialAd.loadAd(adRequest)
    }

    override fun showRewarded(ctx: Context, openLink: () -> Unit) {
        rewardedAd = RewardedAd(ctx)
        rewardedAd.setAdUnitId(YANDEX_REWARDED_ID)
        rewardedAd.setRewardedAdEventListener(object : RewardedAdEventListener {
            override fun onAdLoaded() {
                rewardedAd.show()
                Log.d(YANDEX_REWARDED_TAG,"onAdLoaded")
            }

            override fun onAdFailedToLoad(p0: AdRequestError) {
                Toast.makeText(ctx, "Повторите попытку позже", Toast.LENGTH_SHORT).show()
                Log.d(YANDEX_REWARDED_TAG,"onAdFailedToLoad: ${p0.description}")
            }

            override fun onAdShown() {
                Log.d(YANDEX_REWARDED_TAG,"onAdShown")
            }

            override fun onAdDismissed() {
                Log.d(YANDEX_REWARDED_TAG,"onAdDismissed")
            }

            override fun onRewarded(p0: Reward) {
                openLink()
                Log.d(YANDEX_REWARDED_TAG,"onRewarded: ${p0.type} - ${p0.amount}")
            }

            override fun onAdClicked() {
                Log.d(YANDEX_REWARDED_TAG,"onAdClicked")
            }

            override fun onLeftApplication() {
                Log.d(YANDEX_REWARDED_TAG,"onLeftApplication")
            }

            override fun onReturnedToApplication() {
                Log.d(YANDEX_REWARDED_TAG,"onReturnedToApplication")
            }

            override fun onImpression(p0: ImpressionData?) {
                Log.d(YANDEX_REWARDED_TAG,"onImpression: ${p0.toString()}")
            }

        })
        rewardedAd.loadAd(adRequest)
    }

}