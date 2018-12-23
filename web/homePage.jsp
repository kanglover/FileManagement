<%@ page import="com.entity.Employee" %>
<%--
  Created by IntelliJ IDEA.
  User: kangkang
  Date: 2018/12/5
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    Employee employee = (Employee) session.getAttribute("employee");
%>
<html>
<head>
    <title>首页 文档管理系统</title>
</head>
<link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
<link rel="stylesheet" href="assets/css/font-awesome.min.css"/>
<link rel="stylesheet" href="assets/css/ace.min.css"/>
<link rel="stylesheet" href="assets/ztree/zTreeStyle.css">
<script src=assets/js/jquery.min.js></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/ace.min.js"></script>
<script src="assets/js/ace-elements.min.js"></script>
<script src="assets/js/ace-extra.min.js"></script>
<script src="assets/ztree/jquery.ztree.core.js"></script>
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
        <div class="widget-box widget-color-green">
            <div class="widget-header">
                <h4 class="widget-title lighter smaller"><i class="lighter ace-icon fa fa-book bigger-120" style="display: inline;"></i>知识管理</h4>
            </div>

            <div class="widget-body">
                <div class="widget-main padding-8">
                    <ul id="tree" class="ztree"></ul>
                </div>
            </div>
        </div>
    </div>
    <div class="main-content">
        <iframe scrolling="auto" rameborder="0" src="main.jsp" name="right"
                width="100%" height="100%"></iframe>
    </div>
</div>

</body>

<script type="text/javascript">
    window.onload = function () {
        var zTreeObj;
        var setting = {
            view: {
                dblClickExpand: false,
                showLine: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                onClick: onClick
            }
        };

        zTreeObj = $.fn.zTree.init($("#tree"), setting, <%=session.getAttribute("data")%>);

        // right.window.showTable();
    }


    function onClick(e,treeId, treeNode) {
        window.location="homePage.jsp?" + treeNode.id;
        sessionStorage.setItem("folderName", treeNode.name);
    }
</script>
<style type="text/css">
    .ztree li span.button.ico_docu {
        background-position: -110px 0px;
        margin-right: 2px;
        vertical-align: top;
    }
</style>
</html>
