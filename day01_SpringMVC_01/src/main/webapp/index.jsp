<%--
  Created by IntelliJ IDEA.
  User: 春天在哪里呀
  Date: 2019/1/10
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>入门程序</h3>
<a href="user/hello?username=張三">入门程序</a>

<%--<a href=""></a>--%>
<form action="param/saveAccount" method="post">
    姓名：<input type="text" name="username"></br>
    密碼：<input type="text" name="password"></br>
    金額：<input type="text" name="money"></br>

    <%--&lt;%&ndash;用戶名：<input type="text" name="user.uname"></br>&ndash;%&gt;--%>
    <%--&lt;%&ndash;年齡：<input type="text" name="user.age"></br>&ndash;%&gt;--%>
    <%--&lt;%&ndash;生日：<input type="text" name="user.date"></br>&ndash;%&gt;--%>

    用戶名：<input type="text" name="list[0].uname"></br>
    年齡：<input type="text" name="list[0].age"></br>
    生日：<input type="text" name="list[0].date"></br>

    <%--用戶名：<input type="text" name="map['one'].uname"></br>--%>
    <%--年齡：<input type="text" name="map['one'].age"></br>--%>
    <%--&lt;%&ndash;生日：<input type="text" name="map['one'].date"></br>&ndash;%&gt;--%>
        <input type="submit" value="提交">
</form>

<%--<a href="anno/path/10">Springvc原生API的測試</a>--%>
</body>
</html>
