package com.april2nd.webtest.model.dao;

import com.april2nd.webtest.dto.Note;
import com.april2nd.webtest.dto.User;

import java.util.List;

public interface UserDao {
    public User logIn(User user) throws Exception;
}
