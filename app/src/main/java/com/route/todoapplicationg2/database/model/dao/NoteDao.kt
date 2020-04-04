package com.route.todoapplicationg2.database.model.dao

import androidx.room.*
import com.route.todoapplicationg2.database.model.Note
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface NoteDao {

    @Insert
    fun addNote(note: Note) : Completable

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("delete from note where id = :id")
    fun deleteNoteById(id : Int)

    @Query("select * from note")
    fun getAllNotes() : Flowable<List<Note>>

}