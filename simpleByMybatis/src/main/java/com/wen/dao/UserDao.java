package com.wen.dao;

import com.wen.domain.User;

import java.util.List;

public interface UserDao  {

    List<User> findAll();
}
