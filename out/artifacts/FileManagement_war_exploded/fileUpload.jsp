<%--
  Created by IntelliJ IDEA.
  User: kangkang
  Date: 2018/12/5
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>文件上传</title>
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
<body style="background-color: #fff">
<div>
    <div class="page-content">
        <div class="page-content-area">
            <div class="row">
                <div class="col-xs-12">
                    <form class="form-horizontal" role="form" action="fileUpload.action" method="post"
                          enctype="multipart/form-data" target="_top">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> 文件主题 </label>
                            <div class="col-sm-9">
                                <input type="text" name="file.theme" placeholder="输入文件主题" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> 关键字 </label>
                            <div class="col-sm-9">
                            <textarea name="file.keywords" placeholder="输入关键字" class="col-xs-10 col-sm-5"
                                      required></textarea>
                            </div>
                        </div>
                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> 文件信息 </label>
                            <div class="col-sm-9">
                                <input type="file" name="upload" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> 所属文件夹 </label>
                            <div class="col-sm-9">
                                <s:select list="#session.folders" id="parent" name="file.folder.folderId"
                                          listKey="folderId"
                                          listValue="name"
                                          headerKey="0" headerValue="--请选择--"/>
                            </div>
                        </div>
                        <div class="space-4"></div>

                        <div class="col-md-offset-3 col-md-9">
                            <button class="btn btn-info" type="submit">
                                <i class="ace-icon fa fa-check bigger-110"></i>
                                立即提交
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    window.onload = function (ev) {
        var paraString = top.location.search;
        if (paraString.indexOf("?") === 0) {
            var selectKey = paraString.substr(1);
            $("#parent option[value='" + selectKey + "']").attr("selected", "selected");
        }
    }
</script>
</body>
</html>
