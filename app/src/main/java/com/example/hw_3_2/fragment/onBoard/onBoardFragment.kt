package com.example.hw_3_2.fragment.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.hw_3_2.R
import com.example.hw_3_2.adapter.onBoardPageApdapter
import com.example.hw_3_2.databinding.FragmentOnBoardBinding


class onBoardFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {
        val sharedPref = requireActivity().getSharedPreferences("onBoardPrefs", 0)
        val isCompleted = sharedPref.getBoolean("isOnBoardingCompleted", false)

        if (isCompleted) {
            findNavController().navigate(R.id.action_onBoardFragment_to_noteFragment)
            return null
        }

        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        binding.btnStart.setOnClickListener {
            savedOnBoardingCompleted()
            findNavController().navigate(R.id.action_onBoardFragment_to_noteFragment)
        }
    }

    private fun savedOnBoardingCompleted() {
        val sharedPref = requireActivity().getSharedPreferences("onBoardPrefs", 0)
        sharedPref.edit().putBoolean("isOnBoardingCompleted", true).apply()
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
}
