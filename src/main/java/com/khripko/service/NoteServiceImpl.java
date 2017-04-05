package com.khripko.service;

import com.khripko.dao.NoteDao;
import com.khripko.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao dao;

    @Override
    @Transactional
    public void createNote(Note note) {
        dao.createNote(note);
    }

    @Override
    public Note findById(int id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public void updateNote(Note note) {
        dao.updateNote(note);
    }

    @Override
    @Transactional
    public void deleteNote(int id) {
        dao.deleteNote(id);
    }
}
