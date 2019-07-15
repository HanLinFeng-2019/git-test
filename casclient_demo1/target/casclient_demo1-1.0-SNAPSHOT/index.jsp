<%--
  Created by IntelliJ IDEA.
  User: 春天在哪里呀
  Date: 2019/4/12
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>cas Client demo1</title>
</head>
<body>
 欢迎来到神奇的欢乐谷1号谷!<%=request.getRemoteUser()%>
 <a href="http://localhost:9100/cas/logout?service=http://www.baidu.com">退出登录</a>
</body>
</html>
