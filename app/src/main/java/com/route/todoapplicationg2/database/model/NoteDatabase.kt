package com.route.todoapplicationg2.database.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.route.todoapplicationg2.database.model.dao.NoteDao

@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao() : NoteDao

    companion object {

        var noteDatabase: NoteDatabase? = null
        val DB_NAME = "notes_database"

        fun getInstanse(context: Context): NoteDatabase {
            if (noteDatabase == null) {
                noteDatabase = Room.databaseBuilder(
                    context,
                    NoteDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return noteDatabase as NoteDatabase
        }
    }

}