package com.example.notesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {
    Button delete_btn;
    EditText note_edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Intent intent = getIntent();
        note_edit_text = findViewById(R.id.note_edit_text);
        note_edit_text.setText(intent.getStringExtra("content"));

        delete_btn = findViewById(R.id.delete_btn);
        delete_btn.setOnClickListener((View v) -> {
            MainActivity.database.noteDao().delete(intent.getIntExtra("id", 0));
            Toast.makeText(getApplicationContext(), "Note deleted", Toast.LENGTH_LONG).show();
            finish();
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        MainActivity.database.noteDao().save(id, note_edit_text.getText().toString());
    }
}