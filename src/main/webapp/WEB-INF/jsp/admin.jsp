<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
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
    </style>
</head>
<body>
<div class="content-box">
    <h2 style="text-align: center;">这是授权用户才能进入的页面</h2>
</div>
</body>
</html>
