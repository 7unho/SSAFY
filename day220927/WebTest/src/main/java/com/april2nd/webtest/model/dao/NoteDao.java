package com.april2nd.webtest.model.dao;

import com.april2nd.webtest.dto.Note;

import java.util.List;

public interface NoteDao {
    public int insert(Note note) throws Exception;
    public int update(Note note) throws Exception;
    public int delete(String noteCode) throws Exception;

    public Note selectByNoteCode(String noteCode) throws Exception;
    public List<Note> selectAll() throws Exception;
}
