<%--
  Created by IntelliJ IDEA.
  User: kangkang
  Date: 2018/12/5
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>知识管理</title>
</head>
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="assets/css/ace-fonts.css" />
<link rel="stylesheet" href="assets/css/ace.min.css" id="main-ace-style" />
<script src="assets/js/jquery-2.0.3.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.dataTables.min.js"></script>
<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
<script src="assets/js/ace.min.js"></script>
<script src="assets/js/ace-elements.min.js"></script>
<body>
<div>
    <div class="breadcrumbs" id="breadcrumbs">
        <ul class="breadcrumb">
            <li>
                <i class="ace-icon fa fa-home home-icon"></i>
                <a href="index.html">知识管理</a>
            </li>
        </ul>

        <div class="nav-search" id="nav-search">
            <form class="form-search">
							<span class="input-icon">
								<input type="text" placeholder="请输入关键字 ..." class="nav-search-input"
                                       id="nav-search-input" autocomplete="off"/>
								<i class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
            </form>
        </div>
    </div>
    <div class="page-content">
        <div class="page-content-area">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th class="center">
                                <label class="position-relative">
                                    <input type="checkbox" class="ace" />
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>名称</th>
                            <th>大小</th>
                            <th>最后更新</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="center">
                                <label class="position-relative">
                                    <input type="checkbox" class="ace" />
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <td>
                                <a href="#">国内航班</a>
                            </td>
                            <td>头等舱</td>
                            <td>2件</td>
                            <td>5千克</td>
                        </tr>

                        <tr>
                            <td class="center">
                                <label class="position-relative">
                                    <input type="checkbox" class="ace" />
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <td>
                                <a href="#">国内航班</a>
                            </td>
                            <td>头等舱</td>
                            <td>2件</td>
                            <td>5千克</td>
                        </tr>
                        <tr>
                            <td class="center">
                                <label class="position-relative">
                                    <input type="checkbox" class="ace" />
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <td>
                                <a href="#">国内航班</a>
                            </td>
                            <td>头等舱</td>
                            <td>2件</td>
                            <td>5千克</td>
                        </tr>
                        <tr>
                            <td class="center">
                                <label class="position-relative">
                                    <input type="checkbox" class="ace" />
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <td>
                                <a href="#">国内航班</a>
                            </td>
                            <td>头等舱</td>
                            <td>2件</td>
                            <td>5千克</td>
                        </tr>
                        <tr>
                            <td class="center">
                                <label class="position-relative">
                                    <input type="checkbox" class="ace" />
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <td>
                                <a href="#">国内航班</a>
                            </td>
                            <td>头等舱</td>
                            <td>2件</td>
                            <td>5千克</td>
                        </tr>
                        <tr>
                            <td class="center">
                                <label class="position-relative">
                                    <input type="checkbox" class="ace" />
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <td>
                                <a href="#">国内航班</a>
                            </td>
                            <td hidden-480>头等舱</td>
                            <td hidden-480>2件</td>
                            <td hidden-480>5千克</td>
                        </tr>
                    </tbody>
                    <%--<s:iterator value="classList" var="list" status="status">--%>
                    <%--<tr>--%>
                    <%--<td align="center"><s:property value="id"/></td>--%>
                    <%--<td><s:property value="code"/>(<s:property value="students.size()"/>人)</td>--%>
                    <%--<td>--%>
                    <%--<a onclick="updateClass('<s:property value="#list.key"/>')">编辑</a>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <%--</s:iterator>--%>
                </table>
        </div>
    </div>
</div>
</body>
<script>

</script>
</html>
