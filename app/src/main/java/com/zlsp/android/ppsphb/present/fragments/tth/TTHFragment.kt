package com.zlsp.android.ppsphb.present.fragments.tth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.databinding.FragmentZakonBinding

class TTHFragment : Fragment() {

    lateinit var binding: FragmentZakonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentZakonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance() = TTHFragment()
    }
}