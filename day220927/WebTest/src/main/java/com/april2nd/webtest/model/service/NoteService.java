package com.april2nd.webtest.model.service;

import com.april2nd.webtest.dto.Note;

import java.util.List;

public interface NoteService {
    public int add(Note note) throws Exception;
    public int modify(Note note) throws Exception;
    public int remove(String noteCode) throws Exception;

    public Note findByNoteCode(String noteCode) throws Exception;
    public List<Note> findAll() throws Exception;
}
