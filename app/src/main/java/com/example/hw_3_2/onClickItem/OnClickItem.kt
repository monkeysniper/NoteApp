package com.example.hw_3_2.onClickItem

import com.example.hw_3_2.data.models.NoteModel

interface OnClickItem {
    fun onLongClick(noteModel: NoteModel)

    fun onClick(noteModel: NoteModel)
}