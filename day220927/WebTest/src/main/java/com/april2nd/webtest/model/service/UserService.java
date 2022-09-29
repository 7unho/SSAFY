package com.april2nd.webtest.model.service;

import com.april2nd.webtest.dto.Note;
import com.april2nd.webtest.dto.User;

import java.util.List;

public interface UserService {
    public User logIn(User user) throws Exception;
}
