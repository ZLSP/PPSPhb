package com.zlsp.android.ppsphb.present.fragments.zakon

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.data.ads.YandexAds
import com.zlsp.android.ppsphb.data.singleton.Preferences
import com.zlsp.android.ppsphb.databinding.FragmentZakonBinding
import com.zlsp.android.ppsphb.domain.zakon.ZakonItem

class ZakonFragment : Fragment() {
    private lateinit var viewModel: ZakonViewModel
    private lateinit var binding: FragmentZakonBinding
    private lateinit var zakonListAdapter: ZakonListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentZakonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupZakonListRV()
        viewModel = ViewModelProvider(this)[ZakonViewModel::class.java]
        createZakonList()
        viewModel.zakonList.observe(viewLifecycleOwner) {
            zakonListAdapter.submitList(it)
        }
        setStartArticle()

    }

    @SuppressLint("SetTextI18n")
    private fun setupZakonListRV() {
        zakonListAdapter = ZakonListAdapter()
        with(binding.zakonRvListArticle) {
            adapter = zakonListAdapter
            recycledViewPool.setMaxRecycledViews(
                ZakonListAdapter.VIEW_NO_ACTIVE,
                ZakonListAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                ZakonListAdapter.VIEW_ACTIVE,
                ZakonListAdapter.MAX_POOL_SIZE
            )
        }
        zakonListAdapter.onZakonItemClickListener = {
            if (Preferences.clickCounter())
                YandexAds.showInterstitial()
            clickItemRV(it)
        }
    }

    private fun setStartArticle() {
        val zakonItem = ZakonItem(
            0,
            resources.getStringArray(R.array.array_zakon_article)[0],
            resources.getStringArray(R.array.array_zakon_text)[0],
            active = true)
        clickItemRV(zakonItem)
    }

    private fun clickItemRV(it: ZakonItem) {
        viewModel.changeActiveState(it)
        binding.zakonTvText1.text = "${it.header} \n \n ${it.text1}"
        binding.zakonTvText2.text = it.text2
    }

    private fun createZakonList() {
        val list = mutableListOf<ZakonItem>()
        val arrayArticle = resources.getStringArray(R.array.array_zakon_article)
        val arrayText = resources.getStringArray(R.array.array_zakon_text)
        arrayArticle.forEachIndexed { index, article ->
            when(index) {
                11 -> list.add(ZakonItem(index, article, arrayText[index], arrayText[58]))
                12 -> list.add(ZakonItem(index, article, arrayText[index], arrayText[59]))
                else -> list.add(ZakonItem(index, article, arrayText[index]))
            }
        }
        viewModel.setZakonList(list)
    }

    companion object {
        fun newInstance() = ZakonFragment()
    }
}