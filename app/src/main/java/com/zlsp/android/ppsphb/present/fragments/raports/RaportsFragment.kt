package com.zlsp.android.ppsphb.present.fragments.raports

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.databinding.FragmentRaportsBinding
import com.zlsp.android.ppsphb.databinding.FragmentRedactionBinding
import com.zlsp.android.ppsphb.domain.raports.RaportsItem
import com.zlsp.android.ppsphb.domain.redaction.RedactionItem

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
        setupPolnomochListRV()
        viewModel = ViewModelProvider(this)[RaportsViewModel::class.java]
        createPolnomochList()
        viewModel.raportsList.observe(viewLifecycleOwner){
            raportsListAdapter.submitList(it)
        }
        binding.btnGoneWv.setOnClickListener {
            binding.btnGoneWv.visibility = GONE
            binding.wvDownload.visibility = GONE
        }
    }

    private fun setupPolnomochListRV() {
        raportsListAdapter = RaportsListAdapter()
        binding.raportsRvList.adapter = raportsListAdapter
        raportsListAdapter.onRaportsItemClickListener = {
            if (binding.wvDownload.visibility == GONE)
                openLink(it.link)
        }
    }

    private fun createPolnomochList() {
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
        binding.btnGoneWv.visibility = VISIBLE
        binding.wvDownload.apply {
            visibility = VISIBLE
            settings.javaScriptEnabled = true
            loadUrl(link)
        }
    }

    companion object {
        fun newInstance() = RaportsFragment()
    }
}