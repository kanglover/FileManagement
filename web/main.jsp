<%--
  Created by IntelliJ IDEA.
  User: kangkang
  Date: 2018/12/6
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>主界面</title>
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
<script src="assets/js/ace-extra.min.js"></script>
<script>
    // function showTable() {
    <%--self.frames['table'].document.location.href = "<s:url action="findFiles"></s:url>";--%>
    // }

    window.onload = function (ev) {
        var attribute = sessionStorage.getItem("folderName");
        if (attribute) {
            document.getElementById("attribute").innerText = attribute;
        }
        var paraString = top.location.search;
        if (paraString.indexOf("?") === 0) {
            var selectKey = paraString.substr(1);
            self.frames['table'].document.location.href = "<s:url action="findFiles"></s:url>?pageDTO.folderId=" + selectKey;
        } else {
            self.frames['table'].document.location.href = "<s:url action="findFiles"></s:url>";
        }
    }
</script>
<body>
<div>
    <div class="breadcrumbs" id="breadcrumbs">
        <ul class="breadcrumb">
            <li>
                <i class="ace-icon fa fa-home home-icon"></i>
                <a href="#" id="attribute">知识管理</a>
            </li>
        </ul>

        <div style="float: right">
            <ul class="nav nav-tabs padding-18 tab-size-bigger" style="padding: 5px;">
                <li class="active">
                    <a data-toggle="tab" href="#faq-tab-1">
                        <i class="blue ace-icon fa fa-list bigger-120" style="display: inline;"></i>
                        列表显示
                    </a>
                </li>

                <li>
                    <a data-toggle="tab" href="#faq-tab-2">
                        <i class="green ace-icon fa fa-folder-open bigger-120" style="display: inline;"></i>
                        新建文件夹
                    </a>
                </li>

                <li>
                    <a data-toggle="tab" href="#faq-tab-3">
                        <i class="orange ace-icon fa fa-file bigger-120" style="display: inline;"></i>
                        新建文件
                    </a>
                </li>

                <li>
                    <a data-toggle="tab" href="#faq-tab-4">
                        <i class="orange ace-icon fa fa-cloud-upload bigger-120" style="display: inline;"></i>
                        上传文件
                    </a>
                </li>

                <li>
                    <a data-toggle="tab" href="#faq-tab-5">
                        <i class="orange ace-icon fa  fa-file-zip-o bigger-120" style="display: inline;"></i>
                        zip批量上传
                    </a>
                </li>

                <li>
                    <a data-toggle="tab" href="#faq-tab-6">
                        <i class="orange ace-icon fa fa-search bigger-120" style="display: inline;"></i>
                        查询
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="page-content">
        <div class="page-content-area">
            <div class="row">
                <div class="col-xs-12">
                    <div class="tabbable">
                        <div class="tab-content no-border padding-24">
                            <div id="faq-tab-1" class="tab-pane fade in active">
                                <iframe scrolling="auto" rameborder="0" src="" name="table"
                                        width="100%" height="100%" style="border: 0;"></iframe>
                            </div>

                            <div id="faq-tab-2" class="tab-pane fade">
                                <iframe scrolling="auto" rameborder="0" src="folder.jsp" name="folder"
                                        width="100%" height="100%" style="border: 0;"></iframe>
                            </div>

                            <div id="faq-tab-3" class="tab-pane fade">
                                <iframe scrolling="auto" rameborder="0" src="createFile.jsp"
                                        width="100%" height="100%" style="border: 0;"></iframe>
                            </div>

                            <div id="faq-tab-4" class="tab-pane fade">
                                <iframe scrolling="auto" rameborder="0" src="fileUpload.jsp"
                                        width="100%" height="100%" style="border: 0;"></iframe>
                            </div>

                            <div id="faq-tab-5" class="tab-pane fade">
                                <iframe scrolling="auto" rameborder="0" src=""
                                        width="100%" height="100%" style="border: 0;"></iframe>
                            </div>

                            <div id="faq-tab-6" class="tab-pane fade">
                                <iframe scrolling="auto" rameborder="0" src="preSearch.action"
                                        width="100%" height="100%" style="border: 0;"></iframe>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
