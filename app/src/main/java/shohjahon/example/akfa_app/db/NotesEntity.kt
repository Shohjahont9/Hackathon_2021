package com.example.note.ui.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_entity")
data class NotesEntity(
    var title: String,
    var date: String,
    var sts: Int,
    var progress: Int,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)