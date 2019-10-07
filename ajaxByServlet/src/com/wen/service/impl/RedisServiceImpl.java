package com.wen.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wen.dao.RedisDao;
import com.wen.dao.impl.RedisDaoImpl;
import com.wen.domain.User;
import com.wen.service.RedisService;
import com.wen.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisServiceImpl implements RedisService {
    private RedisDao redisDao = new RedisDaoImpl();
    @Override
    public String findAll() {

        //缓存中取数据
        Jedis jedis = JedisPoolUtils.getJedis();
        String alluser = jedis.get("alluser");

        if(alluser==null||alluser.length()==0){
            //缓冲中没数据
            List<User> all = redisDao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                alluser = mapper.writeValueAsString(all);
                jedis.set("alluser",alluser);
                jedis.close();

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        System.out.println(alluser);
        return alluser;
    }
}
