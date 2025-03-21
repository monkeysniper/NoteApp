package com.example.hw_3_2.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hw_3_2.Fragment.onBoard.onBoardFragment
import com.example.hw_3_2.models.onBoardModel

class onBoardPageApdapter(
    fragment:Fragment,
   private val onBordPages: ArrayList<onBoardModel>
) : FragmentStateAdapter(fragment) {
//    private var list = listOf<onBoardModel>(
//        onBoardModel("Удобство","Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно."),
//        onBoardModel("Удобство","Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно."),
//        onBoardModel("Удобство","Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно."),
//    )

    override fun createFragment(position: Int): Fragment = onBoardFragment().apply {
        val bundle = Bundle()
        arguments = bundle
        bundle.putSerializable("ON_Board", onBordPages[position])
    }


    override fun getItemCount(): Int =2

}






