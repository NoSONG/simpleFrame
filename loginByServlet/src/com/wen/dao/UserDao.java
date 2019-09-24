package com.wen.dao;

import com.wen.domain.User;
import com.wen.util.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    /**
     *  登陆
     * @param user  前端数据封装的user对象
     *
     * @return  数据库中查询出来的user对象
     */
    public User login(User user){
        try {
            //编写sql语句
            String sql = "select * from user where username = ? and password = ?";
            User loginuser = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
            return loginuser;
        }catch (DataAccessException e){
            return null;
        }


    }
}
