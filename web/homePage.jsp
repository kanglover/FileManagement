<%@ page import="com.entity.Employee" %><%--
  Created by IntelliJ IDEA.
  User: kangkang
  Date: 2018/12/5
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Employee employee=(Employee)session.getAttribute("employee");
%>
<html>
<head>
    <title>首页 文档管理系统</title>
</head>
<link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
<link rel="stylesheet" href="assets/css/font-awesome.min.css"/>
<link rel="stylesheet" href="assets/css/ace.min.css"/>
<script src=assets/js/jquery.min.js></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery-ui.custom.min.js"></script>
<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="assets/js/ace.min.js"></script>
<script src="assets/js/ace-elements.min.js"></script>
</head>

<body class="no-skin">
<div id="navbar" class="navbar navbar-default" style="height: 20px">
    <div class="navbar-container" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
            <span class="sr-only">Toggle sidebar</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <div class="navbar-header pull-left">
        </div>
        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue">
                    <a>
                        <span class="user-info">
									欢迎您<br/>
									<%=employee.getName()%>
								</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="main-container" id="main-container">
    <div id="sidebar" class="sidebar responsive">
        <ul class="nav nav-list">
            <li class="active">
                <a href="index.html">
                    <i class="menu-icon fa fa-tachometer"></i>
                    <span class="menu-text"> 菜单 </span>
                </a>
                <b class="arrow"></b>
            </li>

            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-desktop"></i>
                    <span class="menu-text">列表显示</span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href="list.jsp" target="right">
                            <i class="menu-icon fa fa-caret-right"></i>
                            知识管理
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>

            <li class="">
                <a href="" target="right">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> 新建文件夹 </span>
                </a>
                <b class="arrow"></b>
            </li>

            <li class="">
                <a href=""target="right" >
                    <i class="menu-icon fa fa-pencil-square-o"></i>
                    <span class="menu-text"> 新建文件 </span>
                </a>
                <b class="arrow"></b>

            </li>

            <li class="">
                <a href="fileUpload.jsp" target="right">
                    <i class="menu-icon fa fa-list-alt"></i>
                    <span class="menu-text"> 上传文件 </span>
                </a>
                <b class="arrow"></b>
            </li>

            <li class="">
                <a href="" target="right">
                    <i class="menu-icon fa fa-list-alt"></i>
                    <span class="menu-text"> zip批量上传 </span>
                </a>
                <b class="arrow"></b>
            </li>

            <li class="">
                <a href="" target="right">
                    <i class="menu-icon fa fa-list-alt"></i>
                    <span class="menu-text"> 查询 </span>
                </a>
                <b class="arrow"></b>
            </li>
        </ul>
    </div>
    <div class="main-content">
        <iframe scrolling="auto" rameborder="0" src="list.jsp" name="right"
                width="100%" height="100%"></iframe>
    </div>

</div>

</body>
</html>
