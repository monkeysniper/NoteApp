package com.example.hw_3_2.fragment.note

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw_3_2.App
import com.example.hw_3_2.R
import com.example.hw_3_2.data.models.NoteModel
import com.example.hw_3_2.databinding.FragmentNoteBinding
import com.example.hw_3_2.onClickItem.OnClickItem

class NoteFragment : Fragment(), OnClickItem {

    private lateinit var binding: FragmentNoteBinding
    private val noteAdapter = NoteAdapter(this, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initalize()
        setUpListeners()
        getData()
    }

    private fun initalize() {
        binding.rvNote.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
        }
    }

    private fun setUpListeners() = with(binding) {
        btnPlus.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_detailFragment)
        }
    }

    private fun getData() {
        App.appDataBase?.noteDao()?.getAll()?.observe(viewLifecycleOwner){model ->
            noteAdapter.submitList(model)
            noteAdapter.notifyDataSetChanged()
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onLongClick(noteModel: NoteModel) {
        val builder = AlertDialog.Builder(requireContext()).setView(view).create()
        val view = LayoutInflater.from(requireContext()).inflate(R.layout.delete_alert_dialog, null)
        val delete = view.findViewById<TextView>(R.id.delete_ok)
        val cancel = view.findViewById<TextView>(R.id.delete_cancel)

        builder.setView(view)
        val alertDialog = builder
        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        alertDialog.show()

        delete.setOnClickListener {
            App.appDataBase?.noteDao()?.deleteNote(noteModel)
            alertDialog.dismiss()
        }

        cancel.setOnClickListener {
            alertDialog.dismiss()
        }
    }

    override fun onClick(noteModel: NoteModel) {
        val action = NoteFragmentDirections.actionNoteFragmentToDetailFragment(noteModel.id)
        findNavController().navigate(action)
    }
}