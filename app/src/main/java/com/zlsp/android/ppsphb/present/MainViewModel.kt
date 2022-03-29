package com.zlsp.android.ppsphb.present

import android.content.Context
import androidx.lifecycle.ViewModel
import com.yandex.mobile.ads.banner.BannerAdView
import com.zlsp.android.ppsphb.data.impls.MenuListRepositoryImpl
import com.zlsp.android.ppsphb.data.tools.FBAnalyticsRepositoryImpl
import com.zlsp.android.ppsphb.data.tools.PreferencesRepositoryImpl
import com.zlsp.android.ppsphb.data.ads.YandexAdsRepositoryImpl
import com.zlsp.android.ppsphb.domain.fb.FBAnalyticsInitUseCase
import com.zlsp.android.ppsphb.domain.menu.*
import com.zlsp.android.ppsphb.domain.pref.PreferencesInitUseCase
import com.zlsp.android.ppsphb.domain.yandex.YandexAdsInitBunnerUseCase
import com.zlsp.android.ppsphb.domain.yandex.YandexAdsInitUseCase

class MainViewModel: ViewModel() {

    private val repository = MenuListRepositoryImpl
    private val repositoryPref = PreferencesRepositoryImpl
    private val repositoryFB = FBAnalyticsRepositoryImpl
    private val repositoryYandex = YandexAdsRepositoryImpl

    private val setMenuListUseCase = SetMenuListUseCase(repository)
    private val getMenuListUseCase = GetMenuListUseCase(repository)
    private val getMenuItemFragmentUseCase = GetMenuItemFragmentUseCase(repository)

    private val preferencesInitUseCase = PreferencesInitUseCase(repositoryPref)

    private val fbAnalyticsInitUseCase = FBAnalyticsInitUseCase(repositoryFB)

    private val yandexAdsInitBunnerUseCase = YandexAdsInitBunnerUseCase(repositoryYandex)
    private val yandexAdsInitUseCase = YandexAdsInitUseCase(repositoryYandex)

    val menuList = getMenuListUseCase()

    fun setMenuList(list: MutableList<MenuItem>) {
        setMenuListUseCase(list)
    }

    fun initPref(activity: MainActivity) {
        preferencesInitUseCase(activity)
    }

    fun initFB() {
        fbAnalyticsInitUseCase()
    }

    fun initYandexAd(ctx: Context, banner: BannerAdView) {
        yandexAdsInitBunnerUseCase(banner)
        yandexAdsInitUseCase(ctx)
    }

}