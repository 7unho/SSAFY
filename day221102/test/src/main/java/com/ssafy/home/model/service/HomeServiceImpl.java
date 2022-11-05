package com.ssafy.home.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.home.model.dao.HomeDao;
import com.ssafy.home.model.dto.Home;
import com.ssafy.home.model.dto.Sido;

@Service
public class HomeServiceImpl implements HomeService {

	HomeDao dao;
	
	public HomeServiceImpl(HomeDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Sido> siList() {
		return dao.siList();
	}

	@Override
	public List<Home> homeListBySi(String siName) {
		return dao.homeListBySi(siName);
	}

	@Override
	public List<Home> homeListByDong(String dongName) {
		return dao.homeListByDong(dongName);
	}

	@Override
	public List<Home> homeListByGun(String gunName) {
		return dao.homeListByGun(gunName);
	}
	
	@Override
	public List<Home> homeListByApt(String aptName) {
		return dao.homeListByApt(aptName);
	}

}
