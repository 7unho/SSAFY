package com.april2nd.live1.model.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.april2nd.live1.model.dto.Book;
import com.april2nd.live1.model.dto.SearchCondition;

public interface BookService {
    // insert, update, delete
    public int regist(Book book) throws SQLException;
    public int modify(Book book) throws SQLException;
    public int delete(String id) throws SQLException;

    // select, selectAll
    public Book find(String id) throws SQLException;
    public List<Book> findAll() throws SQLException;
}
