package com.zlsp.android.ppsphb.present.fragments.tth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.davemorrissey.labs.subscaleview.ImageSource
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.databinding.FragmentTthBinding
import com.zlsp.android.ppsphb.databinding.FragmentZakonBinding

class TTHFragment : Fragment() {

    private lateinit var binding: FragmentTthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivTth.setImage(ImageSource.resource(R.drawable.tth_pm))
    }

    companion object {
        fun newInstance() = TTHFragment()
    }
}