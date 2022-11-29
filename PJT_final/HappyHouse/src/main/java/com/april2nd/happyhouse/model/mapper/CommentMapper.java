package com.april2nd.happyhouse.model.mapper;

import com.april2nd.happyhouse.model.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface CommentMapper {
    public int writeComment(CommentDto commentDto) throws SQLException;
}
