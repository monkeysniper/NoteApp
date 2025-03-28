package com.example.hw_3_2.fragment.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.hw_3_2.R
import com.example.hw_3_2.databinding.FragmentNoteBinding
import com.example.hw_3_2.databinding.FragmentOnBoardPageBinding
import com.example.hw_3_2.utils.PrefereceHelper


class NoteFragment : Fragment() {
private lateinit var binding: FragmentNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentNoteBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

//    private fun setupListeners():Unit=with(binding) {
//        val shared=PrefereceHelper()
//        shared.unit(requireContext())
//        btnSave.setOnClickListener{
//            val et: String =etText.text.toString()
//            shared.text=et
//            txtText.text=et
//        }
//        txtText.text=shared.text
    }



