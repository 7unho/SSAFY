package com.live1.model.service;

import com.live1.dto.Book;
import com.live1.dto.User;
import com.live1.model.repo.BookRepo;
import com.live1.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private BookRepo bookRepo;
    public BookServiceImpl(BookRepo bookRepo) {this.bookRepo = bookRepo;}

    @Override
    public int regist(Book book) throws SQLException {
        return bookRepo.insert(book);
    }

    @Override
    public int modify(Book book) throws SQLException {
        return 0;
    }

    @Override
    public int delete(String id) throws SQLException {
        return 0;
    }

    @Override
    public Book find(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Book> findAll() throws SQLException {
        return bookRepo.selectAll();
    }
}
