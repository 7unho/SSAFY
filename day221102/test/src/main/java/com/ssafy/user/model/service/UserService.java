package com.ssafy.user.model.service;

import com.ssafy.user.model.dto.User;

public interface UserService {
	User userSelect(String id);
	int regist(User user);
	int modify(User user);
	int remove(String id);
}
