package com.zlsp.android.ppsphb.present

import android.content.Context
import androidx.lifecycle.ViewModel
import com.yandex.mobile.ads.banner.BannerAdView
import com.zlsp.android.ppsphb.data.impls.lists.MenuListRepositoryImpl
import com.zlsp.android.ppsphb.data.impls.singleton.FBAnalyticsRepositoryImpl
import com.zlsp.android.ppsphb.data.impls.singleton.PreferencesRepositoryImpl
import com.zlsp.android.ppsphb.data.impls.singleton.YandexAdsRepositoryImpl
import com.zlsp.android.ppsphb.domain.menu.*

class MainViewModel: ViewModel() {

    private val repository = MenuListRepositoryImpl
    private val repositoryPref = PreferencesRepositoryImpl
    private val repositoryFB = FBAnalyticsRepositoryImpl
    private val repositoryYandex = YandexAdsRepositoryImpl

    private val setMenuListUseCase = SetMenuListUseCase(repository)
    private val getMenuListUseCase = GetMenuListUseCase(repository)
    private val getMenuItemFragmentUseCase = GetMenuItemFragmentUseCase(repository)

    val menuList = getMenuListUseCase()

    fun setMenuList(list: MutableList<MenuItem>) {
        setMenuListUseCase(list)
    }

    fun initPref(activity: MainActivity) {
        repositoryPref.initPref(activity)
    }

    fun initFB() {
        repositoryFB.initFB()
    }

    fun initYandexAd(ctx: Context, banner: BannerAdView) {
        repositoryYandex.initYandex(ctx)
        repositoryYandex.initInterstitial(ctx)
        repositoryYandex.initBanner(banner)
    }

}