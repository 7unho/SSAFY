package com.ssafy.home.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.home.model.dto.Home;
import com.ssafy.home.model.dto.Sido;

public interface HomeDao {
	List<Sido> siList();
	
	String gunList(String code) throws SQLException;
	
	String dongList(String code) throws SQLException;
	
//	List<Home> homeListByDong(String dongName) throws SQLException;
	
	List<Home> homeListByDong(String dongName, String sort) throws SQLException;
	
	List<Home> homeListBySi(String siName);
	List<Home> homeListByGun(String gunName);
	List<Home> homeListByDong(String dongName);
	List<Home> homeListByApt(String aptName);
}
