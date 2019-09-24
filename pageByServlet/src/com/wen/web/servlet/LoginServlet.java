package com.wen.web.servlet;


import com.wen.domain.User;
import com.wen.service.UserService;
import com.wen.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet( "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取提交的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verifycode = request.getParameter("verifycode");

        //判断输入是否正确
        //获取存储的验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码错误
            request.setAttribute("err_login_msg","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        Map<String, String[]> parameterMap = request.getParameterMap();

        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //判断用户名密码是否正确
        UserService userService = new UserServiceImpl();
        User quser = userService.Login(user);
        if(quser!=null){
            //登陆成功
            session.setAttribute("login_user",quser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");

        }else{
            request.setAttribute("err_login_msg","帐号或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


        System.out.println(username+"=="+password+"=="+verifycode +"=="+quser);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
