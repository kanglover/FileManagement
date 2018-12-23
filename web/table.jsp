<%@ page import="com.entity.PageDTO" %><%--
  Created by IntelliJ IDEA.
  User: kangkang
  Date: 2018/12/5
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>知识管理</title>
</head>
<link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
<link rel="stylesheet" href="assets/css/font-awesome.min.css"/>
<link rel="stylesheet" href="assets/css/ace-fonts.css"/>
<link rel="stylesheet" href="assets/css/ace.min.css" id="main-ace-style"/>
<script src="assets/js/jquery-2.0.3.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.dataTables.min.js"></script>
<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
<script src="assets/js/ace.min.js"></script>
<script src="assets/js/ace-elements.min.js"></script>
<script src="assets/js/ace-extra.min.js"></script>
<style>
    ul a {
        height: 37px;
    }
</style>
<body style="background-color: #fff">
<div class="page-content">
    <div class="page-content-area">
        <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th class="center">
                    <label class="position-relative">
                        <input type="checkbox" class="ace" id="checkAll"/>
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

            <s:iterator value="#session.files" var="list" status="status">
                <tr>
                    <td class="center">
                        <label class="position-relative">
                            <input type="checkbox" class="ace" name="cbo" value="<s:property value="fileId"/>"/>
                            <span class="lbl"></span>
                        </label>
                    </td>
                    <td>
                        <s:property value="fileName"/>
                    </td>
                    <td><s:property value="fileSize"/></td>
                    <td><s:date name="modifyDate" format="yyyy-MM-dd HH:mm:ss"/> <s:property
                            value="modifier.name"/></td>
                    <td>
                        <a role="button" data-toggle="modal" target="table" href="#"
                           onclick="lookAttribute(<s:property value="fileId"/>)">
                            属性</a>
                        <a href="#" onclick="editName(this, '<s:property value="fileId"/>')">重命名</a>
                        <a href="#" onclick="deleteFile('<s:property value="fileId"/>')">删除</a>
                        <a href="<s:url action="fileDownload"><s:param name="file.fileId" value="fileId"/></s:url>">下载</a>
                    </td>
                </tr>
            </s:iterator>
            </tbody>

            <tfoot>
            <tr>
                <td colspan="6" align="center">
                    <ul class="pagination pull-left no-margin">
                        <button class="btn btn-white btn-info btn-bold" onclick="lookHistory()">
                            <i class="ace-icon fa fa-history bigger-120 blue"></i>
                            历史
                        </button>
                        <button class="btn btn-white btn-warning btn-bold" onclick="deleteFiles()">
                            <i class="ace-icon fa fa-trash-o bigger-120 orange"></i>
                            删除
                        </button>
                        <button class="btn btn-white btn-warning btn-bold" onclick="downloadMoreFile()">
                            <i class="ace-icon fa fa-download bigger-120 orange"></i>
                            下载
                        </button>
                    </ul>
                    <ul class="pagination pull-right no-margin">
                        <li class="prev">
                            <s:if test="pageDTO.currentPage-1 == 0">
                                <a>
                                    <i class="ace-icon fa fa-angle-double-left"></i>
                                </a></s:if>
                            <s:else>
                                <a href="turnPage.action?pageDTO.currentPage=<s:property value="pageDTO.currentPage-1"/>&pageDTO.totalPage=<s:property value="pageDTO.totalPage"/>">
                                    <i class="ace-icon fa fa-angle-double-left"></i>
                                </a>
                            </s:else>
                        </li>
                        <%
                            PageDTO pageDTO = (PageDTO) request.getAttribute("pageDTO");
                            if (null != pageDTO.getTotalCount()) {
                                session.setAttribute("totalCount", pageDTO.getTotalCount());
                                session.setAttribute("totalPage", pageDTO.getTotalPage());
                            }
                        %>

                        <s:iterator
                                begin="pageDTO.currentPage>4?pageDTO.currentPage+5>#session.totalPage?#session.totalPage>10?#session.totalPage-9:1:pageDTO.currentPage-4:1"
                                end="pageDTO.currentPage>4?pageDTO.currentPage+5>#session.totalPage?#session.totalPage:pageDTO.currentPage+5:#session.totalPage>10?10:#session.totalPage"
                                var="i">
                            <s:if test="pageDTO.currentPage==#i">
                                <li class="active">
                                    <a href="#" class="current_page"><s:property value="#i"/></a>
                                </li>
                            </s:if>
                            <s:else>
                                <li>
                                    <a href="turnPage.action?pageDTO.currentPage=<s:property value="#i"/>&pageDTO.totalPage=<s:property value="pageDTO.totalPage"/>"><s:property
                                            value="#i"/></a>
                                </li>
                            </s:else>
                        </s:iterator>

                        <li class="next">
                            <s:if test="pageDTO.currentPage == pageDTO.totalPage">
                                <a>
                                    <i class="ace-icon fa fa-angle-double-right"></i>
                                </a></s:if>
                            <s:else>
                                <a href="turnPage.action?pageDTO.currentPage=<s:property
                                        value="pageDTO.currentPage+1"/>&pageDTO.totalPage=<s:property value="pageDTO.totalPage"/>">
                                    <i class="ace-icon fa fa-angle-double-right"></i>
                                </a>
                            </s:else>
                        </li>
                    </ul>

                    <%--总共<s:property value="pageDTO.totalCount"/>条数据--%>
                    总共<s:property value="#session.totalCount"/>条数据
                </td>
            </tr>
            </tfoot>

        </table>

        <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            属性
                        </h4>
                    </div>
                    <div class="modal-body">
                        <ul class="list-unstyled spaced">
                            <li>文件名：<s:property value="file.fileName"/></li>
                            <li>文件类型：<s:property value="file.fileType"/></li>
                            <li>位置：<s:property value="file.folder.savePath"/></li>
                            <li>大小：<s:property value="file.fileSize"/></li>
                            <li>创建时间：<s:date name="file.modifyDate" format="yyyy-MM-dd HH:mm:ss"/></li>
                            <li>修改时间：<s:date name="file.createDate" format="yyyy-MM-dd HH:mm:ss"/></li>
                        </ul>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary">
                        提交更改
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
<script>
    function editName(td, id) {
        var element = $(td).parent().parent()[0].children[1];
        $(element).html("<input type='text' onblur='rename(this, " + id + ")' value='" + element.innerText + "'> ");
    }

    function rename(e, id) {
        $(e).parent().html(e.value);
        window.location.href = "<s:url action="updateFile"></s:url>?file.fileId=" + id + "&file.fileName=" + e.value;
    }

    function deleteFile() {
        if (confirm("确实是否删除")) {
            window.location.href = "<s:url action="deleteFile"></s:url>?file.fileId=" + id;
        }
    }

    function lookAttribute(id) {
        window.location.href = "<s:url action="findFile"></s:url>?file.fileId=" + id;
    }

    function getIds() {
        var files = new Array();
        $("input[name='cbo']:checked").each(function () {
            files.push($(this).val());
        });
        return files;
    }

    function lookHistory() {
        var files = getIds();
        if (files.length == 0) {
            alert("请至少选择一个文件");
        }
        else {
            window.location.href = "findHistories.action?files=" + files;
        }
    }

    function deleteFiles() {
        var files = getIds();
        if (files.length == 0) {
            alert("请至少选择一个文件");
        }
        else {
            if (confirm("确实是否删除")) {
                window.location.href = "<s:url action="deleteFiles"></s:url>?ids=" + files;
            }
        }
    }

    function downloadMoreFile() {
        var files = getIds();
        if (files.length == 0) {
            alert("请至少选择一个文件");
        }
        else {
            window.location.href = "<s:url action="downloadMoreFile"></s:url>?ids=" + files;
        }
    }

    window.onload = function (ev) {
        if (<%=request.getAttribute("files") == null%>) {
            $('#modal').modal('show')
        }
    }
    $(function () {
        //实现全选反选
        $("#checkAll").on('click', function () {
            $("tbody input:checkbox").prop("checked", $(this).prop('checked'));
        })
        $("tbody input:checkbox").on('click', function () {
            if ($("tbody input:checkbox").length === $("tbody input:checked").length) {
                $("#checkAll").prop("checked", true);
            } else {
                $("#checkAll").prop("checked", false);
            }
        })


    })
</script>
</html>
