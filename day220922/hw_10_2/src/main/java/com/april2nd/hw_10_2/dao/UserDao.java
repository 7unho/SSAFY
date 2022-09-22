package com.april2nd.hw_10_2.dao;

import java.sql.SQLException;
import java.util.List;

import com.april2nd.hw_10_2.dto.User;

public interface UserDao {

    List<User> selectAllUsers() throws SQLException;

    boolean insertUser(User user)throws SQLException;

    int userCount() throws SQLException;

}
