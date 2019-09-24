<%--
  Created by IntelliJ IDEA.
  User: wenhe
  Date: 2019/9/7
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script>
        /*
            分析：
                点击超链接或者图片，需要换一张
                1.给超链接和图片绑定单击事件

                2.重新设置图片的src属性值

         */
        window.onload = function(){
            //1.获取图片对象
            var img = document.getElementById("checkCode");
            //2.绑定单击事件
            img.onclick = function(){
                //加时间戳
                var date = new Date().getTime();

                img.src = "/login/checkCodeServlet?"+date;
            }

        }


    </script>

    <style>
        div{
            color: red;
        }


    </style>
</head>
<body>
<form action="/login/loginServlet" method="post">
    用户名 :<input type="text" name="username"> <br>
    密码 :<input type="password" name="password"><br>
    验证码 : <input type="text" name="checkcode"><br>
    <img id="checkCode" src="/login/checkCodeServlet" />
    <input type="submit" value="登录">

</form>


<div><%= request.getAttribute("err_user") == null? "": request.getAttribute("err_user")%></div>
<div><%= request.getAttribute("err_check") == null? "": request.getAttribute("err_check")%></div>
</body>
</html>
