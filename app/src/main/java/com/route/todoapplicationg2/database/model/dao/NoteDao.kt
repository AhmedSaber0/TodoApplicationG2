package com.route.todoapplicationg2.database.model.dao

import androidx.room.*
import com.route.todoapplicationg2.database.model.Note

@Dao
interface NoteDao {

    @Insert
    fun addNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("delete from note where id = :id")
    fun deleteNoteById(id : Int)

    @Query("select * from note")
    fun getAllNotes() : List<Note>

}