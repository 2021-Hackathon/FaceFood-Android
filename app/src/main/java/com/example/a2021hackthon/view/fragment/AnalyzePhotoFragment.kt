package com.example.a2021hackthon.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.a2021hackthon.databinding.FragmentHomeFaceAnalyzeBinding
import com.example.a2021hackthon.model.remote.dto.EmotionFood
import com.example.a2021hackthon.view.utils.MessageUtils
import com.example.a2021hackthon.viewmodel.AnalyzePhotoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnalyzePhotoFragment : Fragment() {

    private val navController by lazy { findNavController() }

    private lateinit var binding: FragmentHomeFaceAnalyzeBinding

    private val viewModel: AnalyzePhotoViewModel by viewModels()

    private val navArgs by navArgs<AnalyzePhotoFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeFaceAnalyzeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()

        val photoUri = navArgs.photoUri.toUri()

        binding.imageView.setImageURI(photoUri)

        Thread.sleep(1000L)
        viewModel.postAnalyzePhoto(requireContext(), photoUri)
    }

    private fun observe() = with (viewModel) {
        isSuccess.observe(viewLifecycleOwner) {
            navController.navigate(
                AnalyzePhotoFragmentDirections.actionAnalyzePhotoFragmentToAnalyzePhotoResultFragment(
                    it.emotion, it.food, it.URL
                ))
        }

        isFailure.observe(viewLifecycleOwner) {
            MessageUtils.showDialog(requireActivity(), it)
        }
    }

}