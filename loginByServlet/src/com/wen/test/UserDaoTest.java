package com.wen.test;

import com.wen.dao.UserDao;
import com.wen.domain.User;


public class UserDaoTest {

    @org.junit.Test
    public void LoginTest(){
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("root");
        user.setPassword("root");
        User login = userDao.login(user);
        System.out.println(login);
    }
}
