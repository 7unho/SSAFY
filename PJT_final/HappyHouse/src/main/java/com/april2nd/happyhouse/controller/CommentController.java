package com.april2nd.happyhouse.controller;

import java.util.List;

import com.april2nd.happyhouse.model.BoardDto;
import com.april2nd.happyhouse.model.CommentDto;
import com.april2nd.happyhouse.model.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

//http://localhost:9999/vue/swagger-ui.html
//@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST} , maxAge = 6000)
@RestController
@RequestMapping("/comment")
@Api("댓글 컨트롤러  API V1")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";


    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "댓글작성", notes = "새로운 댓글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
    @PostMapping
    public ResponseEntity<String> writeComment(@RequestBody @ApiParam(value = "댓글 정보.", required = true) CommentDto commentDto) throws Exception {
        System.out.println("writeArticle - 호출");
        System.out.println(commentDto.toString());
        if (commentService.writeComment(commentDto)) {
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }
}