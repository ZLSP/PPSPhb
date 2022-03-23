package com.zlsp.android.ppsphb.present.fragments.raports

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.ktx.Firebase
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import com.yandex.mobile.ads.rewarded.Reward
import com.yandex.mobile.ads.rewarded.RewardedAd
import com.yandex.mobile.ads.rewarded.RewardedAdEventListener
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.data.ads.YandexAds
import com.zlsp.android.ppsphb.data.singleton.FBAnalytics
import com.zlsp.android.ppsphb.databinding.FragmentRaportsBinding
import com.zlsp.android.ppsphb.domain.raports.RaportsItem

class RaportsFragment : Fragment() {

    private lateinit var viewModel: RaportsViewModel
    private lateinit var binding: FragmentRaportsBinding
    private lateinit var raportsListAdapter: RaportsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRaportsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRaportsListRV()
        viewModel = ViewModelProvider(this)[RaportsViewModel::class.java]
        createRaportsList()
        viewModel.raportsList.observe(viewLifecycleOwner){
            raportsListAdapter.submitList(it)
        }
        binding.btnGoneWv.setOnClickListener {
            binding.btnGoneWv.visibility = GONE
            binding.wvDownload.visibility = GONE
        }
    }

    private fun setupRaportsListRV() {
        raportsListAdapter = RaportsListAdapter()
        binding.raportsRvList.adapter = raportsListAdapter
        raportsListAdapter.onRaportsItemClickListener = {
            if (binding.wvDownload.visibility == GONE) {
                initRewarded(it.link)
                FBAnalytics.firebaseLog(FB_LOG)
            }
        }
    }

    private fun createRaportsList() {
        val list = mutableListOf<RaportsItem>()
        val arrayName = resources.getStringArray(R.array.array_raports_name)
        val arrayLink = resources.getStringArray(R.array.array_raports_link)
        arrayName.forEachIndexed { index, name ->
            list.add(RaportsItem(index, name, arrayLink[index]))
        }
        viewModel.setRaportsList(list)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun openLink(link: String) {
        //binding.btnGoneWv.visibility = VISIBLE
        val uri = Uri.parse(link)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
//        binding.wvDownload.apply {
//            visibility = VISIBLE
//            settings.javaScriptEnabled = true
//            loadUrl(link)
//        }
    }

    private fun initRewarded(link: String) {
        YandexAds.rewardedAd = RewardedAd(requireContext())
        YandexAds.rewardedAd.setAdUnitId(YandexAds.YANDEX_REWARDED_ID)
        YandexAds.rewardedAd.setRewardedAdEventListener(object : RewardedAdEventListener {
            override fun onAdLoaded() {
                YandexAds.rewardedAd.show()
                Log.d(YandexAds.YANDEX_REWARDED_TAG,"onAdLoaded")
            }

            override fun onAdFailedToLoad(p0: AdRequestError) {
                Toast.makeText(requireContext(), "Повторите попытку позже", Toast.LENGTH_SHORT).show()
                Log.d(YandexAds.YANDEX_REWARDED_TAG,"onAdFailedToLoad: ${p0.description}")
            }

            override fun onAdShown() {
                Log.d(YandexAds.YANDEX_REWARDED_TAG,"onAdShown")
            }

            override fun onAdDismissed() {
                Log.d(YandexAds.YANDEX_REWARDED_TAG,"onAdDismissed")
            }

            override fun onRewarded(p0: Reward) {
                openLink(link)
                Log.d(YandexAds.YANDEX_REWARDED_TAG,"onRewarded: ${p0.type} - ${p0.amount}")
            }

            override fun onAdClicked() {
                Log.d(YandexAds.YANDEX_REWARDED_TAG,"onAdClicked")
            }

            override fun onLeftApplication() {
                Log.d(YandexAds.YANDEX_REWARDED_TAG,"onLeftApplication")
            }

            override fun onReturnedToApplication() {
                Log.d(YandexAds.YANDEX_REWARDED_TAG,"onReturnedToApplication")
            }

            override fun onImpression(p0: ImpressionData?) {
                Log.d(YandexAds.YANDEX_REWARDED_TAG,"onImpression: ${p0.toString()}")
            }

        })
        YandexAds.rewardedAd.loadAd(YandexAds.adRequest)
    }

    companion object {
        const val FB_LOG = FirebaseAnalytics.Event.ADD_TO_CART
        fun newInstance() = RaportsFragment()
    }
}