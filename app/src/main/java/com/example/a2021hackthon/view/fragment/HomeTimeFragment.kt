package com.example.a2021hackthon.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.a2021hackthon.R
import com.example.a2021hackthon.databinding.FragmentHomeTimeBinding
import com.example.a2021hackthon.viewmodel.TimeViewModel
import dagger.hilt.android.AndroidEntryPoint

class HomeTimeFragment : Fragment() {

    private lateinit var binding: FragmentHomeTimeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeTimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStartHomeTime.setOnClickListener {
            val bundle = Bundle()
            bundle.putBoolean("isSurvey", false)
            findNavController().navigate(R.id.action_homeFragment_to_loadingFragment, bundle)
        }
    }
}