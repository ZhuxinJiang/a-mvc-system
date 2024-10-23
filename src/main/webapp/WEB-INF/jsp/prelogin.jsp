<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PreLogin</title>
    <style>
        /* 居中对齐 */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 90vh;
            background-color: rgb(250, 230, 245); /* 背景色 */
        }

        /* 内容框样式 */
        .content-box {
            padding: 60px;
            border: 2px solid rgba(0, 0, 0, 0.5); /* 边框 */
            border-radius: 20px; /* 边框圆角 */
            background-color: rgb(246, 237, 244); /* 背景色 */
        }

        /* 超链接样式 */
        a {
            font-size: 18px; /* 设置超链接字体大小 */
        }
    </style>
</head>
<body>
<div class="content-box">
    <h2><font color="red">${msg}</font></h2><br/>
    <div style="text-align: center;">
        <a href="login.do">去登录</a><br/><br/><br/>
        <a href="register.do">去注册</a><br/>
    </div>
</div>
</body>
</html>
