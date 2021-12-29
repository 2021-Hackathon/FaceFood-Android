package com.example.a2021hackthon.view.activity.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.a2021hackthon.R
import com.example.a2021hackthon.base.BaseFragment
import com.example.a2021hackthon.databinding.FragmentSurveyBinding
import com.example.a2021hackthon.view.adapter.Survey
import com.example.a2021hackthon.view.adapter.SurveyViewPagerAdapter

class SurveyFragment : BaseFragment<FragmentSurveyBinding>() {

    private lateinit var viewPagerAdapter: SurveyViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSurveyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingViewPager()
    }

    private fun bindingViewPager() {
        val list = mutableListOf<Survey>()

        val content = resources.getStringArray(R.array.surveyContent)
        val answer1 = resources.getStringArray(R.array.surveyAnswer1)
        val answer2 = resources.getStringArray(R.array.surveyAnswer2)

        for (i in 0..content.size - 1) {
            list.add(Survey(content[i], answer1[i], answer2[i]))
            Log.d("List", list.toString())
        }

        binding.surveyViewPager.apply {
            orientation - ViewPager2.ORIENTATION_HORIZONTAL
            viewPagerAdapter = SurveyViewPagerAdapter()
            adapter = viewPagerAdapter
            viewPagerAdapter.setData(list)
        }

        binding.surveyViewPager.setOnClickListener {
            binding.surveyViewPager.currentItem++
        }


    }
}