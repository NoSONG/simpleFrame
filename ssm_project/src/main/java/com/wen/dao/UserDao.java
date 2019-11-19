package com.wen.dao;

import com.wen.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    /**
     * 查找全部
     * @return
     */
    @Select("select * from user1")
    List<User> findAll();

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    @Select("select * from user1 where id = #{id}")
    User findById(int id);
}
