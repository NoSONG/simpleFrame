package com.wen.dao;

import com.wen.domain.PageBean;
import com.wen.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    User findByUsernameAndPassword(String username,String password);

    List<User> findUserByPage(int start, int rows, Map<String,String[]> parameters);


    int findTotalCount(Map<String, String[]> parameters);

    void delUser(String id);
}
