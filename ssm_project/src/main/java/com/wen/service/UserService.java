package com.wen.service;

import com.wen.domain.User;

import java.util.List;

public interface UserService {

    /**
     * 查询全部
     * @return
     */
    List<User> findAll();

    /**
     * 通过id查询
     * @param user
     * @return
     */
    User findById(int id);
}
