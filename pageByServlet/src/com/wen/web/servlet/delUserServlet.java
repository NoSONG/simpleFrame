package com.wen.web.servlet;

import com.wen.service.UserService;
import com.wen.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUserServlet")
public class delUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //单个删
        String id = request.getParameter("id");
        //选中删
        String[] uids = request.getParameterValues("uid");
        UserService userService = new UserServiceImpl();
        if(id!=null&& "".equals(id)){
            userService.delUser(id);
        }
        if(uids!=null&& uids.length>=0){
            userService.delUsers(uids);
        }

        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
