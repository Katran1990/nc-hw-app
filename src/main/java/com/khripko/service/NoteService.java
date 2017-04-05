package com.khripko.service;

import com.khripko.model.Note;

public interface NoteService {

    void createNote(Note note);

    Note findById(int id);

    void updateNote(Note note);

    void deleteNote(int id);
}
