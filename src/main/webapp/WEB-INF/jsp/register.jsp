<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 90vh;
            background-color: rgb(250, 230, 245); /* 背景色 */
        }

        .content-box {
            padding: 60px;
            border: 2px solid rgba(0, 0, 0, 0.5); /* 边框 */
            border-radius: 20px; /* 边框圆角 */
            background-color: rgb(246, 237, 244); /* 背景色 */
        }

        .button-container {
            text-align: center;
            margin-top: 20px; /* 修改这里的值来调整间距 */
        }
    </style>
</head>
<body>
<div class="content-box">
    <h1 style="text-align: center;">用户注册</h1><br/>
    <form name="registerForm" action="doregister.do" method="post" onsubmit="return validateForm()">
        姓名：<input type="text" name="username" value="<%= request.getAttribute("username") %>"/><br/><br/>
        密码：<input type="password" name="password" value="<%= request.getAttribute("password") %>"/><br/><br/><br/>
        <div class="button-container">
            <input type="submit" value="注册"/>
            <a href="login.do" style="margin-left: 40px;">去登录</a>
        </div>
    </form>
    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="error" style="color: red;text-align: center;">
        <%= request.getAttribute("errorMessage") %>
    </div>
    <% } %>
</div>
</body>
</html>
