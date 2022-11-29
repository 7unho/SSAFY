package com.april2nd.happyhouse.model.service;

import com.april2nd.happyhouse.model.CommentDto;

public interface CommentService {
    public boolean writeComment(CommentDto commentDto) throws Exception;
}
