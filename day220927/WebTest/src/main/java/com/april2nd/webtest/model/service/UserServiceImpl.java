package com.april2nd.webtest.model.service;

import com.april2nd.webtest.dto.Note;
import com.april2nd.webtest.dto.User;
import com.april2nd.webtest.model.dao.NoteDaoImpl;
import com.april2nd.webtest.model.dao.UserDaoImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();
    public UserDaoImpl userDao = UserDaoImpl.getInstance();

    private UserServiceImpl() {}

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public User logIn(User user) throws Exception {
        return userDao.logIn(user);
    }
}
