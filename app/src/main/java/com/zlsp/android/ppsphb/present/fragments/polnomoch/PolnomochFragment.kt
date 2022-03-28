package com.zlsp.android.ppsphb.present.fragments.polnomoch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.data.ads.YandexAds
import com.zlsp.android.ppsphb.databinding.FragmentPolnomochBinding
import com.zlsp.android.ppsphb.domain.polnomoch.PolnomochItem

class PolnomochFragment : Fragment() {

    private lateinit var viewModel: PolnomochViewModel
    private lateinit var binding: FragmentPolnomochBinding
    private lateinit var polnomochListAdapter: PolnomochListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPolnomochBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPolnomochListRV()
        viewModel = ViewModelProvider(this)[PolnomochViewModel::class.java]
        createPolnomochList()
        viewModel.polnomochList.observe(viewLifecycleOwner){
            polnomochListAdapter.submitList(it)
        }
    }

    private fun setupPolnomochListRV() {
        polnomochListAdapter = PolnomochListAdapter()
        with(binding.polnomochRvList) {
            adapter = polnomochListAdapter
            recycledViewPool.setMaxRecycledViews(
                PolnomochListAdapter.VIEW_LOCKED,
                PolnomochListAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                PolnomochListAdapter.VIEW_OPEN,
                PolnomochListAdapter.MAX_POOL_SIZE
            )
        }
        polnomochListAdapter.onPolnomochItemClickListener = {
            viewModel.apply {
                if (clickCounter()) showInterstitial()
                changeOpenState(it)
            }
        }
    }

    private fun createPolnomochList() {
        val list = mutableListOf<PolnomochItem>()
        val arrayName = resources.getStringArray(R.array.array_polnomoch_name)
        val arrayText = resources.getStringArray(R.array.array_polnomoch_text)
        arrayName.forEachIndexed { index, name ->
            list.add(PolnomochItem(index, name, arrayText[index]))
        }
        viewModel.setPolnomochList(list)
    }

    companion object {
        fun newInstance() = PolnomochFragment()
    }
}