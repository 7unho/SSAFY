package com.ssafy.home.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.home.model.dto.Home;
import com.ssafy.home.model.dto.Sido;
import com.ssafy.home.model.service.HomeService;

@Controller
public class HomeController {
	
	HomeService service;
	
	public HomeController(HomeService service) {
		this.service = service;
	}

	@GetMapping({"/", "index"})
	public String showIndex() {
		return "index";
	}
	
	@GetMapping("/news")
	public String showNews() {
		return "news";
	}
	
	@GetMapping("/init")
	public void getSiList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Sido> sidoList = service.siList();
		JSONObject jo = new JSONObject();
		JSONArray jaa = new JSONArray();
		for(Sido s:sidoList) {
			JSONObject temp = new JSONObject();
			temp.put("code", s.getDongCode());
			temp.put("code", s.getSidoName());
			jaa.add(temp);
		}
		jo.put("regcodes", jaa);
		String siList = jo.toString();
		request.setAttribute("siList", siList);
		PrintWriter out = response.getWriter();
		out.println(siList);
		out.close();
		return;
	}
	
	@PostMapping("/search")
	public String search(HttpServletRequest request) {
		String option = request.getParameter("option");
		String name = request.getParameter("name");
		List<Home> searchResult = null;
		if(option==null) {
			searchResult = service.homeListByApt("광화문");
			request.setAttribute("searchResult", searchResult);
			return "searchResult";
		}
		switch(option) {
		case "si":
			searchResult = service.homeListBySi(name);
			break;
		case "gun":
			searchResult = service.homeListByGun(name);
			break;
		case "dong":
			searchResult = service.homeListByDong(name);
			break;
		case "apt":
			searchResult = service.homeListByApt(name);
			break;
			
		}
		
		request.setAttribute("searchResult", searchResult);
		return "searchResult";
	}
}
