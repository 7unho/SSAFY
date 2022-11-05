package com.ssafy.user.model.dao;

import com.ssafy.user.model.dto.User;

public interface UserDao {
	User select(String id);
	int insert(User user);
	int update(User user);
	int delete(String id);
}
