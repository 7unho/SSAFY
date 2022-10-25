package com.live1.model.repo;

import com.live1.dto.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookRepo {
    int insert(Book book) throws SQLException;
    int update(Book book) throws SQLException;
    int delete(String id) throws SQLException;

    Book select(String id) throws SQLException;
    List<Book> selectAll() throws SQLException;
}
