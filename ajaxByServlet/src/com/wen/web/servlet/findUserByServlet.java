package com.wen.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/findUserByServlet")
public class findUserByServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("application/json;charset=utf-8");
        String username = req.getParameter("username");
        //此处查询数据库


        Map<String,Object> map = new HashMap<String, Object>();
        map.put("exsit",true);
        map.put("msg","注册吧,准了");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),map);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
