package com.wen.web;

import com.wen.util.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 下载文件的servlet
 */
@WebServlet("/downFileServlet")
public class DownFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取参数文件名
        String filename = request.getParameter("filename");
        // 获取ServletContext
        ServletContext servletContext = getServletContext();
        //获取服务器路径
        String realPath = servletContext.getRealPath("/img/" + filename);
        //获取文件mime类型
        String mimeType = servletContext.getMimeType(filename);

        // 文件输入流
        FileInputStream fis = new FileInputStream(realPath);
        //处理中文文件名
        String agent = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent, filename);
        //设置response的响应头
        response.setHeader("content-type",mimeType);
        response.setHeader("content-disposition","attachment;filename="+filename);

        //获取输出流
        ServletOutputStream outputStream = response.getOutputStream();

        //写出数据
        byte[] buff= new byte[1024];
        int len;
        while((len=fis.read(buff))!=-1){
            outputStream.write(buff,0,len);
        }

        fis.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
