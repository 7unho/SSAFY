package com.ssafy.home.model.service;

import java.util.List;

import com.ssafy.home.model.dto.Home;
import com.ssafy.home.model.dto.Sido;

public interface HomeService {
	List<Sido> siList();
	
	List<Home> homeListBySi(String siName);
	List<Home> homeListByGun(String gunName);
	List<Home> homeListByDong(String dongName);
	List<Home> homeListByApt(String aptName);
}
