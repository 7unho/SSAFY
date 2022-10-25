package com.live1.model.service;

import com.live1.dto.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookService {
    // insert, update, delete
    public int regist(Book book) throws SQLException;
    public int modify(Book book) throws SQLException;
    public int delete(String id) throws SQLException;

    // select, selectAll
    public Book find(String id) throws SQLException;
    public List<Book> findAll() throws SQLException;
}
