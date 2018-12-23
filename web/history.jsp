<%--
  Created by IntelliJ IDEA.
  User: kangkang
  Date: 2018/12/17
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>历史记录</title>
</head>
<link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
<link rel="stylesheet" href="assets/css/font-awesome.min.css"/>
<link rel="stylesheet" href="assets/css/ace-fonts.css"/>
<link rel="stylesheet" href="assets/css/ace.min.css" id="main-ace-style"/>
<script src="assets/js/jquery-2.0.3.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/ace.min.js"></script>
<script src="assets/js/ace-elements.min.js"></script>
<script src="assets/js/ace-extra.min.js"></script>
<body style="background-color: #fff">
<div class="page-content">
    <div class="page-content-area">
        <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th>用户</th>
                <th>时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>

            <s:iterator value="histories" var="list" status="status">
                <tr>
                    <td><s:property value="operator.name"/></td>
                    <td><s:date name="operateDate" format="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><s:property value="operate"/></td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
