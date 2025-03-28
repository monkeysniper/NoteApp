package com.example.hw_3_2.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hw_3_2.fragment.onBoard.onBoardPageFragment

class onBoardPageApdapter(
    fragment:Fragment,
) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment = onBoardPageFragment().apply {
        val bundle = Bundle()
        arguments = bundle
        bundle.putInt(onBoardPageFragment.ARG_ONBOARD_POSITION, position)
    }


    override fun getItemCount(): Int = 3

}






