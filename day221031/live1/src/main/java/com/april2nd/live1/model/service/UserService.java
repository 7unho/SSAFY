package com.april2nd.live1.model.service;

import com.april2nd.live1.model.dto.User;

import java.sql.SQLException;

public interface UserService {
    // user : id, name, pass
    public int regist(User user) throws SQLException;
    public int modify(User user) throws SQLException;
    public int delete(String id) throws SQLException;

    // select, selectAll
    public int idCheck(String id) throws SQLException;
    public User loginUser(User user) throws SQLException;
}
