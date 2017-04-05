package com.khripko.dao;

import com.khripko.model.Note;

public interface NoteDao {

    void createNote(Note note);

    Note findById(int id);

    void updateNote(Note note);

    void deleteNote(int id);
}
