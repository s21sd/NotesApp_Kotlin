package com.example.notessql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notessql.databinding.ActivityAddNotesBinding

class AddNotesActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddNotesBinding
    private lateinit var db:NotesDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db= NotesDatabaseHelper(this)
        binding.saveButton.setOnClickListener{
            val title=binding.editTextView.text.toString()
            val content=binding.editTextViewtwo.text.toString()
            val note=Notes(0,title,content)
            db.insertNote(note)
            finish()

            Toast.makeText(this,"Note Saved",Toast.LENGTH_SHORT).show()
        }
    }
}