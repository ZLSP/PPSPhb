package com.zlsp.android.ppsphb.present.fragments.osnov

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.databinding.FragmentOsnovBinding
import com.zlsp.android.ppsphb.domain.osnov.OsnovItem

class OsnovFragment : Fragment() {
    private lateinit var viewModel: OsnovViewModel
    private lateinit var binding: FragmentOsnovBinding
    private lateinit var osnovListAdapter: OsnovListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOsnovBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupOsnovListRV()
        viewModel = ViewModelProvider(this)[OsnovViewModel::class.java]
        createOsnovList()
        viewModel.osnovList.observe(viewLifecycleOwner){
            osnovListAdapter.submitList(it)
        }
    }

    private fun setupOsnovListRV() {
        osnovListAdapter = OsnovListAdapter()
        with(binding.osnovRvList) {
            adapter = osnovListAdapter
            recycledViewPool.setMaxRecycledViews(
                OsnovListAdapter.VIEW_LOCKED,
                OsnovListAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                OsnovListAdapter.VIEW_OPEN,
                OsnovListAdapter.MAX_POOL_SIZE
            )
        }
        osnovListAdapter.onOsnovItemClickListener = {
            viewModel.changeActiveState(it)
        }
    }

    private fun createOsnovList() {
        val list = mutableListOf<OsnovItem>()
        val arrayName = resources.getStringArray(R.array.array_osnov_name)
        val arrayArticle = resources.getStringArray(R.array.array_osnov_article)
        val arrayText = resources.getStringArray(R.array.array_osnov_text)
        arrayName.forEachIndexed { index, name ->
            list.add(OsnovItem(index, name, arrayArticle[index], arrayText[index]))
        }
        viewModel.setOsnovList(list)
    }

    companion object {
        fun newInstance() = OsnovFragment()
    }
}