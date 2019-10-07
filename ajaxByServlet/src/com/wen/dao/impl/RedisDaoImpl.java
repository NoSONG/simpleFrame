package com.wen.dao.impl;

import com.wen.dao.RedisDao;
import com.wen.domain.User;
import com.wen.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RedisDaoImpl implements RedisDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<User> findAll() {

        String sql = "select * from user";
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return query;
    }
}
