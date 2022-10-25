package com.live1.model.service;

import com.live1.dto.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    // insert, update, delete
    public int regist(User user) throws SQLException;
    public int modify(User user) throws SQLException;
    public int delete(String id) throws SQLException;

    // select, selectAll
    public int idCheck(String id) throws SQLException;
    public User loginUser(User user) throws SQLException;
}
