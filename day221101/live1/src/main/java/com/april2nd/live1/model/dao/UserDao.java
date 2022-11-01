package com.april2nd.live1.model.dao;

import java.util.List;

import com.april2nd.live1.model.dto.SearchCondition;
import com.april2nd.live1.model.dto.User;

public interface UserDao {
	
	int insert(User user);
	
	User searchById(String id);
	
	List<User> selectAll();
	
	List<User> searchByName(String name);

	List<User> searchByCondition(SearchCondition con);
}
