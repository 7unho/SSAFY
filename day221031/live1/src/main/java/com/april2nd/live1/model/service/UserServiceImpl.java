package com.april2nd.live1.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.april2nd.live1.model.dao.UserDao;
import com.april2nd.live1.model.dto.User;

import java.sql.SQLException;

/**
 * 빈으로 등록될 수 있도록 @Service를 선언한다.
 *
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userRepo;

    @Autowired
    public UserServiceImpl(UserDao userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public int regist(User user) throws SQLException {
        return userRepo.insert(user);
    }

    @Override
    public int modify(User user) throws SQLException {
        return userRepo.update(user);
    }

    @Override
    public int delete(String id) throws SQLException {
        return userRepo.delete(id);
    }

    @Override
    public int idCheck(String id) throws SQLException {
        return userRepo.idCheck(id);
    }

    @Override
    public User loginUser(User user) throws SQLException {
        return userRepo.loginUser(user);
    }
}
