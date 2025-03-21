package com.example.hw_3_2.Fragment.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }

    private fun initialize() {
       val onBoardPageApdapter=onBoardPageApdapter(this@onBoardFragment,generateOnBoardPages())
        binding.viewPager.adapter=onBoardPageApdapter
    }
    private fun generateOnBoardPages() : ArrayList<onBoardModel> = arrayListOf(
        onBoardModel(
            "Удобство",
            "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно."
        ),
        onBoardModel(
            "Организация",
            "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время."
        ),
        onBoardModel(
            "Синхронизация",
            "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте."
        )
    )
}