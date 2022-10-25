package com.live1.model.repo;

import com.live1.dto.User;
import java.sql.SQLException;

public interface UserRepo {
    int insert(User book) throws SQLException;
    int update(User book) throws SQLException;
    int delete(String id) throws SQLException;

    int idCheck(String id) throws SQLException;
    User loginUser(User user) throws SQLException;
}
