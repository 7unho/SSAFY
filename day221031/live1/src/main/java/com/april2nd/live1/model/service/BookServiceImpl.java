package com.april2nd.live1.model.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.april2nd.live1.model.dao.BookDao;
import com.april2nd.live1.model.dto.Book;
import com.april2nd.live1.model.dto.SearchCondition;
import com.april2nd.live1.util.PageNavigation;

/**
 * 빈으로 등록될 수 있도록 @Service를 선언한다.
 *
 */
@Service
public class BookServiceImpl implements BookService {
    public BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public int regist(Book book) throws SQLException {
        return bookDao.insert(book);
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
        return bookDao.selectAll();
    }
}
