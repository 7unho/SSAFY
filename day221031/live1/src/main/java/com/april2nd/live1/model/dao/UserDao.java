package com.april2nd.live1.model.dao;

import com.april2nd.live1.model.dto.User;

import java.sql.SQLException;

public interface UserDao {
    int insert(User book) throws SQLException;
    int update(User book) throws SQLException;
    int delete(String id) throws SQLException;

    int idCheck(String id) throws SQLException;
    User loginUser(User user) throws SQLException;
}
