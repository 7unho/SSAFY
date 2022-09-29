package com.april2nd.webtest.model.service;

import com.april2nd.webtest.dto.Note;
import com.april2nd.webtest.model.dao.NoteDaoImpl;

import java.util.List;

public class NoteServiceImpl implements NoteService{
    private static NoteServiceImpl instance = new NoteServiceImpl();
    public NoteDaoImpl noteDao = NoteDaoImpl.getInstance();

    private NoteServiceImpl() {}

    public static NoteServiceImpl getInstance() {
        return instance;
    }

    @Override
    public int add(Note note) throws Exception {
        return noteDao.insert(note);
    }

    @Override
    public int modify(Note note) throws Exception {
        return noteDao.update(note);
    }

    @Override
    public int remove(String noteCode) throws Exception {
        return noteDao.delete(noteCode);
    }

    @Override
    public Note findByNoteCode(String noteCode) throws Exception {
        return noteDao.selectByNoteCode(noteCode);
    }

    @Override
    public List<Note> findAll() throws Exception {
        return noteDao.selectAll();
    }
}
