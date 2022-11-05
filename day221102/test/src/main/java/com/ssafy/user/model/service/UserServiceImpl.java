package com.ssafy.user.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.user.model.dao.UserDao;
import com.ssafy.user.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	UserDao dao;
	
	public UserServiceImpl(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public User userSelect(String id) {
		return dao.select(id);
	}

	@Override
	public int regist(User user) {
		return dao.insert(user);
	}

	@Override
	public int modify(User user) {
		return dao.update(user);
	}

	@Override
	public int remove(String id) {
		return dao.delete(id);
	}

}
