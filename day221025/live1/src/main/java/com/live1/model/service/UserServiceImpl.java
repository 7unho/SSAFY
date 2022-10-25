package com.live1.model.service;

import com.live1.dto.User;
import com.live1.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService{
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
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
