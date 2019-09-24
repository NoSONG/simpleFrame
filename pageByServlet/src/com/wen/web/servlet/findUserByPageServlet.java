package com.wen.web.servlet;

import com.wen.domain.PageBean;
import com.wen.service.UserService;
import com.wen.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class findUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        //获取参数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if(currentPage==null||"".equalsIgnoreCase(currentPage)){
            currentPage="1";
        }

        if(rows==null||"".equalsIgnoreCase(rows)){
            rows="5";
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        UserService userService = new UserServiceImpl();
        PageBean userByPage = userService.findUserByPage(currentPage, rows, parameterMap);

        request.setAttribute("pb",userByPage);
        request.setAttribute("condition",parameterMap);
        request.getRequestDispatcher("/list.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
