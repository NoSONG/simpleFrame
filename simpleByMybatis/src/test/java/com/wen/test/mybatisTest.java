package com.wen.test;


import com.wen.dao.AccountDao;
import com.wen.dao.UserDao;
import com.wen.domain.Account;
import com.wen.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class mybatisTest {
    InputStream in;
    SqlSessionFactoryBuilder builder;
    SqlSessionFactory factory;
    SqlSession sqlSession;
    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("sqlmapConfig.xml");
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        sqlSession = factory.openSession();
    }
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        in.close();
    }
    @Test
    public void findAllTest() throws IOException {


        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> all = mapper.findAll();

        for (User u:all) {
            System.out.println(u);
        }

    }
    @Test
    public void finTest(){
        AccountDao mapper =  sqlSession.getMapper(AccountDao.class);
        List<Account> all = mapper.findAll();

        for (Account u:all) {
            System.out.println(u);
        }
    }
}
