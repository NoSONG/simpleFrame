package com.wen.service;

import com.wen.domain.PageBean;
import com.wen.domain.User;

import java.util.Map;

public interface UserService {
    User Login(User user);

    PageBean findUserByPage(String currentPage, String rows, Map<String,String[]> parameters);

    void delUser(String id);

    void delUsers(String[] uids);
}
