package com.april2nd.live1.controller;

import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.april2nd.live1.model.dto.SearchCondition;
import com.april2nd.live1.model.dto.User;
import com.april2nd.live1.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })

public class UserRestController {

	@Autowired
	UserService us;

	@GetMapping("/user")
	@ApiOperation(value = "돈.까.쓰 소스입니다", response = User.class)
//	public List<User> selectAll() throws Exception{		//리턴 Data
//		return us.selectAll();
//	}
	public ResponseEntity<?> selectAll() {   //ResponseEntity<리턴Data의 Type>  : 리턴 Data + 서버 status
		try {
			List<User> users = us.selectAll();
			if (users != null  && users.size() > 0 ) { //users데이터를 정상적으로 얻어왔을때   그리고 데이터의 개수가 1개 이상일때
//				return new ResponseEntity<데이터타입>(데이터, 서버상태);
				return new ResponseEntity<List<User>>(users, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); //전달할 내용 없음
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/user/{id}")
	@ApiOperation(value = "{id}에 해당하는 사용자 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> select(@PathVariable String id) {
		 try {
		 	User user = us.searchById(id);
		 	if (user != null) { //id에 해당하는 User정보 있을때
		 		return new ResponseEntity<User>(user, HttpStatus.OK);
		 	} else {//id에 해당하는 User정보 없을때
		 		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		 	}
		 } catch (Exception e) {
		 	return exceptionHandling(e);
		 }
	}

	@GetMapping("/user/search")
	@ApiOperation(value = "SearchCondition 에 부합하는 조건을 가진 사용자 목록을 반환한다.", response = User.class)
	public ResponseEntity<?> search(SearchCondition con) {
		try {
			List<User> users = us.searchByCondition(con);
			if (users != null  && users.size() > 0 ) { //users데이터를 정상적으로 얻어왔을때   그리고 데이터의 개수가 1개 이상일때
//				return new ResponseEntity<데이터타입>(데이터, 서버상태);
				return new ResponseEntity<List<User>>(users, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); //전달할 내용 없음
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@PostMapping("/user")
	@ApiOperation(value = "사용자 정보를 삽입한다.", response = Integer.class)
	public ResponseEntity<?> insert(User user) {
		 try {
		 	int result = us.insert(user);
		 	return new ResponseEntity<Integer>(result, HttpStatus.CREATED);

		 } catch (Exception e) {
		 	return exceptionHandling(e);
		 }
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
