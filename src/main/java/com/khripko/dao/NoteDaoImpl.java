package com.khripko.dao;

import com.khripko.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class NoteDaoImpl implements NoteDao {

    @Autowired
    private JdbcTemplate template;

    @Override
    public void createNote(Note note) {
        String sql = "INSERT INTO DEFAULT_USER.NOTE (NOTE_ID, TITLE) VALUES (DEFAULT_USER.S_NOTE_ID.NEXTVAL, ?);";
        template.update(sql, note.getTitle());
    }

    @Override
    public Note findById(int id) {
        String sql = "SELECT * FROM DEFAULT_USER.NOTE WHERE NOTE_ID = ?";
        return template.queryForObject(sql, new Object[]{id}, new NoteMapper());
    }

    @Override
    public void updateNote(Note note) {
        String sql = "INSERT INTO DEFAULT_USER.NOTE (NOTE_ID, TITLE) VALUES (?, ?);";
        template.update(sql, note.getId(), note.getTitle());
    }

    @Override
    public void deleteNote(int id) {
        String sql = "DELETE FROM DEFAULT_USER.NOTE WHERE NOTE_ID = ?";
        template.update(sql, id);
    }

    private class NoteMapper implements RowMapper<Note> {
        public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Note(
                    rs.getInt("NOTE_ID"),
                    rs.getString("TITLE"));
        }
    }
}
