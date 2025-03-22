package com.example.hw_3_2.Fragment.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw_3_2.R
import com.example.hw_3_2.databinding.FragmentOnBoardBinding
import com.example.hw_3_2.databinding.FragmentOnBoardPageBinding


class onBoardPageFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardPageBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardPageBinding. inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initalize()
    }

    private fun initalize()= with(binding) {
        when (requireArguments().getInt(ARG_ONBOARD_POSITION)){
            0 -> {
                lottieAnimation.setAnimation(R.raw.synchronization_animation)
                txtNotes.text = "Notes"
                txtTitle.text = "Удобство"
                txtDescription.text = "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно."
            }
            1 -> {
                lottieAnimation.setAnimation(R.raw.organization_animation)
                txtNotes.text = "Notes"
                txtTitle.text = "Организация"
                txtDescription.text = "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время."
            }
            2 -> {
                lottieAnimation.setAnimation(R.raw.convenience_animation)
                txtNotes.text = "Notes"
                txtTitle.text = "Синхронизация"
                txtDescription.text = "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте."
            }
        }
    }

    companion object {
        const val ARG_ONBOARD_POSITION="onBoard"
    }
}