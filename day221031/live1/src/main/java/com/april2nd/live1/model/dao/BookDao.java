package com.april2nd.live1.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.april2nd.live1.model.dto.Book;
import com.april2nd.live1.model.dto.SearchCondition;

public interface BookDao {
    int insert(Book book) throws SQLException;
    int update(Book book) throws SQLException;
    int delete(String id) throws SQLException;

    Book select(String id) throws SQLException;
    List<Book> selectAll() throws SQLException;
}
