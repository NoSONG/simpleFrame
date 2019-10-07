package com.wen.dao;

import com.wen.domain.User;

import java.util.List;

public interface RedisDao {
    List<User> findAll();
}
