package com.route.todoapplicationg2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.route.todoapplicationg2.database.model.Note
import com.route.todoapplicationg2.database.model.NoteDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)


        addButton.setOnClickListener {
            addNote()
        }
    }

    private fun addNote() {
        val addNoteDisposable = NoteDatabase.getInstanse(this).noteDao().addNote(
            Note(
                titleEditText.text.toString(),
                contentEditText.text.toString(),
                timeEditText.text.toString()
            )
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Toast.makeText(this, "note added successfully", Toast.LENGTH_LONG).show()
            },
                {
                    Toast.makeText(this, "Error adding note", Toast.LENGTH_LONG).show()
                }
            )
        disposable.add(addNoteDisposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}

