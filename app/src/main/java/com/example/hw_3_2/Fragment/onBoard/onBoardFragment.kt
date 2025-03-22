package com.example.hw_3_2.Fragment.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.hw_3_2.R
import com.example.hw_3_2.adapter.onBoardPageApdapter
import com.example.hw_3_2.databinding.FragmentOnBoardBinding
import com.example.hw_3_2.models.onBoardModel


class onBoardFragment : Fragment() {
    private lateinit var binding:FragmentOnBoardBinding

private var onBoardPageApdapter:onBoardPageApdapter?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding. inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        changeActiveOnboardShower(0)
    }

    private fun initialize() {
        binding.viewpanger2.adapter = onBoardPageApdapter(this)
    }

    private fun setupListener() = with(binding.viewpanger2) {
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 2) {
                    binding.btnStart.visibility = View.VISIBLE
                    binding.txtSkip.visibility = View.GONE
                } else {
                    binding.btnStart.visibility = View.GONE
                    binding.txtSkip.visibility = View.VISIBLE
                    binding.txtSkip.setOnClickListener {
                        if (currentItem < 3) {
                            setCurrentItem(currentItem + 2, true)
                        }
                    }
                }
            }
        })
    }

    private fun changeActiveOnboardShower(position : Int) {
        val onboardShowers = binding.onboardShowers
        for (i in 0 until onboardShowers.childCount) {
            val onboardShower = onboardShowers.getChildAt(i)
            if (i == position) {
                onboardShower.setBackgroundResource(R.drawable.ic_ellipse)
            } else {
                onboardShower.setBackgroundResource(R.drawable.ic_elipse)
            }
        }
    }
}
