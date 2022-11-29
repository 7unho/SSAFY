package com.april2nd.happyhouse.model.service;

import com.april2nd.happyhouse.model.CommentDto;
import com.april2nd.happyhouse.model.mapper.CommentMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private SqlSession sqlSession;

    @Override
    public boolean writeComment(CommentDto commentDto) throws Exception {
        if(commentDto.getContent() == null || commentDto.getWriter() == null) {
            throw new Exception();
        }
        return sqlSession.getMapper(CommentMapper.class).writeComment(commentDto) == 1;
    }
}
