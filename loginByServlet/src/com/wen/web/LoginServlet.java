package com.wen.web;

import com.wen.dao.UserDao;
import com.wen.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserDao userDao = new UserDao();
        User login = userDao.login(user);
        response.setContentType("text/html;charset=utf-8");
        if(login!=null){
            HttpSession session = request.getSession();
            String checkcode_session = (String) session.getAttribute("checkcode");
            //获取session保存的验证码数据后,删除记录以防止验证码多次使用
            session.removeAttribute("checkcode");
            if(checkcode_session!=null&&checkcode_session.equalsIgnoreCase(checkcode)){//验证
                //验证成功
                session.setAttribute("user",login.getUsername());
                response.sendRedirect("/login/index.jsp");

            }else{
                request.setAttribute("err_check","验证码错误!!");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        }else{
            request.setAttribute("err_user","帐号或密码错误!!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
