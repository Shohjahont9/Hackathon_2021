package com.example.note.ui.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAO {
    @Query("SELECT*FROM notes_entity")
    suspend fun allNotes(): List<NotesEntity>

    @Query("SELECT*FROM notes_entity WHERE sts=:sts")
    suspend fun getNotesBySts(sts: Int): List<NotesEntity>

    @Delete
    suspend fun deleteNotes(notesEntity: NotesEntity)

    @Query("UPDATE notes_entity SET title=:message WHERE id=:id ")
    suspend fun updateMessage(message: String, id: Int)

    @Query("UPDATE notes_entity SET date=:date WHERE id=:id ")
    suspend fun updateDate(date: String, id: Int)

    @Query("UPDATE notes_entity SET sts=:sts WHERE id=:id ")
    suspend fun updateSts(sts: Int, id: Int)

    @Query("UPDATE notes_entity SET progress=:progress WHERE id=:id ")
    suspend fun updateProgress(progress: Int, id: Int)

    @Insert
    suspend fun insertMessage(notesEntity: NotesEntity)

}