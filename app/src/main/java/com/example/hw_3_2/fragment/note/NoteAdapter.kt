package com.example.hw_3_2.fragment.note

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_3_2.R
import com.example.hw_3_2.data.models.NoteModel
import com.example.hw_3_2.databinding.ItemNoteBinding
import com.example.hw_3_2.onClickItem.OnClickItem

class NoteAdapter(
    private val onLongCLick: OnClickItem,
    private val onCLick: OnClickItem,
): ListAdapter<NoteModel, NoteAdapter.ViewHolder>(DiffCallback()) {
    class ViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun bind(item: NoteModel){
            binding.txtName.text = item.title
            binding.txtAbout.text = item.description
            binding.tvData.text = item.date
            binding.rvNotesItem.backgroundTintList = ColorStateList.valueOf(
                if (item.color == 0) ContextCompat.getColor(binding.root.context, R.color.yellow) else item.color
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))

        holder.itemView.setOnLongClickListener {
            onLongCLick.onLongClick(getItem(position))
            true
        }

        holder.itemView.setOnClickListener {
            onCLick.onClick(getItem(position))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    class DiffCallback: DiffUtil.ItemCallback<NoteModel>(){
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem == newItem
        }
    }
}