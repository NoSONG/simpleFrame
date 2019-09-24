package com.wen.dao.impl;

import com.wen.dao.UserDao;
import com.wen.domain.PageBean;
import com.wen.domain.User;
import com.wen.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByUsernameAndPassword(String username ,String password) {


        String sql = "select * from user where username=? and password=?";
        User query = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);

        return query;
    }

    /**
     * 查询满足条件的所有记录并封装到list
     * @param start
     * @param rows
     * @param parameters
     * @return
     */
    @Override
    public List<User> findUserByPage(int start, int rows, Map<String,String[]> parameters) {
        //按条件查询并分页
        String sql = "select * from user where 1=1";
        StringBuilder builder = new StringBuilder(sql);

        Set<String> strings = parameters.keySet();
        List<Object> parameter_seach = new ArrayList<>();

        for (String string : strings) {
            //判断是否是判断条件
            if("currentPage".equals(string)||"rows".equals(string)){
                continue;
            }
            String value = parameters.get(string)[0];
            //拼接sql语句
            if(value!=null && !"".equals(value)){
                builder.append(" and "+string+" like ? ");
                parameter_seach.add("%"+value+"%");
            }

        }
        builder.append(" limit ?,?");
        parameter_seach.add(start);
        parameter_seach.add(rows);
        sql = builder.toString();
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class),parameter_seach.toArray());
    }

    /**
     * 查询满足条件的记录总数
     * @param parameters
     * @return
     */
    @Override
    public int findTotalCount(Map<String, String[]> parameters) {
        String sql = "select count(*) from user where 1=1";
        StringBuilder builder = new StringBuilder(sql);

        Set<String> strings = parameters.keySet();

        List<Object> parameter_seach = new ArrayList<>();

        for (String string : strings) {
            if("currentPage".equals(string)||"rows".equals(string)){
                continue;
            }

            String value = parameters.get(string)[0];
            //拼接sql语句
            if(value!=null && !"".equals(value)){
                builder.append(" and "+string+" like ? ");
                parameter_seach.add("%"+value+"%");
            }

        }
        System.out.println(builder.toString());
        System.out.println(parameter_seach);
        sql=builder.toString();


        return jdbcTemplate.queryForObject(sql,Integer.class,parameter_seach.toArray());
    }

    @Override
    public void delUser(String id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql,id);
    }
}
