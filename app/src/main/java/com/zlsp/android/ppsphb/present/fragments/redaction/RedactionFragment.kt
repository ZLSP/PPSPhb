package com.zlsp.android.ppsphb.present.fragments.redaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.data.ads.YandexAds
import com.zlsp.android.ppsphb.databinding.FragmentRedactionBinding
import com.zlsp.android.ppsphb.domain.polnomoch.PolnomochItem
import com.zlsp.android.ppsphb.domain.redaction.RedactionItem

class RedactionFragment : Fragment() {

    private lateinit var viewModel: RedactionViewModel
    private lateinit var binding: FragmentRedactionBinding
    private lateinit var redactionListAdapter: RedactionListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRedactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPolnomochListRV()
        viewModel = ViewModelProvider(this)[RedactionViewModel::class.java]
        createPolnomochList()
        viewModel.redactionList.observe(viewLifecycleOwner){
            redactionListAdapter.submitList(it)
        }
    }

    private fun setupPolnomochListRV() {
        redactionListAdapter = RedactionListAdapter()
        with(binding.redactionRvList) {
            adapter = redactionListAdapter
            recycledViewPool.setMaxRecycledViews(
                RedactionListAdapter.VIEW_LOCKED,
                RedactionListAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                RedactionListAdapter.VIEW_OPEN,
                RedactionListAdapter.MAX_POOL_SIZE
            )
        }
        redactionListAdapter.onRedactionItemClickListener = {
            viewModel.apply {
                if (clickCounter()) showInterstitial()
                changeOpenState(it)
            }
        }
    }

    private fun createPolnomochList() {
        val list = mutableListOf<RedactionItem>()
        val arrayName = resources.getStringArray(R.array.array_redaction_name)
        val arrayText = resources.getStringArray(R.array.array_redaction_text)
        arrayName.forEachIndexed { index, name ->
            list.add(RedactionItem(index, name, arrayText[index]))
        }
        viewModel.setRedactionList(list)
    }

    companion object {
        fun newInstance() = RedactionFragment()
    }
}