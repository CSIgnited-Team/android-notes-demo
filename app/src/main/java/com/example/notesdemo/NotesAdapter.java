package com.example.notesdemo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {
    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout containerLayout;
        public TextView contentTextView;

        public NoteViewHolder(View view) {
            super(view);
            this.containerLayout = view.findViewById(R.id.note_row_layout);
            this.contentTextView = view.findViewById(R.id.note_row_text);

            this.containerLayout.setOnClickListener((View v) -> {
                Note current = (Note) containerLayout.getTag();
                Intent intent = new Intent(v.getContext(), NoteActivity.class);
                intent.putExtra("id", current.id);
                intent.putExtra("content", current.content);

                v.getContext().startActivity(intent);
            });
        }
    }

    private List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_row, parent, false);

        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note current = notes.get(position);
        holder.containerLayout.setTag(current);
        holder.contentTextView.setText(current.content);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void reload() {
        notes = MainActivity.database.noteDao().getAll();
        notifyDataSetChanged();
    }
}
