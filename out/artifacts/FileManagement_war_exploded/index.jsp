<%--
  Created by IntelliJ IDEA.
  User: kangkang
  Date: 2018/12/4
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>用户登录</title>
</head>
<style>
    .whole {
        margin: 20px auto;
    }
</style>
<body>
<div class="whole">
    <s:form action="login" namespace="/" method="post">
        <s:fielderror cssStyle="color:red">
            <s:param>error</s:param>
        </s:fielderror>
        <s:textfield name="account" label="账号"></s:textfield>
        <br/>
        <s:password name="password" label="密码"></s:password>
        <br/>
        <s:submit value="提交"></s:submit>
    </s:form>
</div>
</body>
</html>
