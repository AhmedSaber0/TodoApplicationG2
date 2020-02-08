package com.route.todoapplicationg2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.todoapplicationg2.database.model.Note
import com.route.todoapplicationg2.database.model.NoteDatabase
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)


        addButton.setOnClickListener {
            NoteDatabase.getInstanse(this).noteDao().addNote(
                Note(
                    titleEditText.text.toString(),
                    contentEditText.text.toString(),
                    timeEditText.text.toString()
                )
            )
        }
    }
}
