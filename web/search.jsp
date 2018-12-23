<%--
  Created by IntelliJ IDEA.
  User: kangkang
  Date: 2018/12/17
  Time: 10:31
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
<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css"/>
<link rel="stylesheet" href="assets/css/chosen.css"/>
<link rel="stylesheet" href="assets/css/datepicker.css"/>
<link rel="stylesheet" href="assets/css/bootstrap-timepicker.css"/>
<link rel="stylesheet" href="assets/css/daterangepicker.css"/>
<link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css"/>
<link rel="stylesheet" href="assets/css/colorpicker.css"/>
<link rel="stylesheet" href="assets/css/ace-fonts.css"/>
<link rel="stylesheet" href="assets/css/ace.min.css" id="main-ace-style"/>
<link rel="stylesheet" href="assets/css/ace-part2.min.css"/>
<link rel="stylesheet" href="assets/css/ace-ie.min.css"/>

<script src="assets/js/ace-extra.min.js"></script>
<body style="background-color: #fff">
<div class="page-content">
    <div class="page-content-area">
        <div class="row">
            <div class="col-xs-12">
                <form class="form-horizontal" role="form" action="searchFiles.action" method="post">
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"> 文件名 </label>
                        <div class="col-sm-9">
                            <input type="text" name="file.fileName" placeholder="输入文件名" class="col-xs-10 col-sm-5"/>
                        </div>
                    </div>
                    <div class="space-4"></div>

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
                            <textarea name="file.keywords" placeholder="输入关键字" class="col-xs-10 col-sm-5"></textarea>
                        </div>
                    </div>
                    <div class="space-4"></div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"> 创建者 </label>
                        <div class="col-sm-9">
                            <%--<s:select list="deparments" name="file.creator.department.did"--%>
                            <%--listKey="did"--%>
                            <%--listValue="name"--%>
                            <%--headerKey="0" headerValue="请选择部门"/>--%>
                            <s:select list="employees" name="file.creator.eid"
                                      listKey="eid"
                                      listValue="name"
                                      headerKey="0" headerValue="请选择人员"/>
                        </div>
                    </div>
                    <div class="space-4"></div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">创建日期</label>
                        <div class="col-sm-4">
                            <div class="input-daterange input-group">
                                <input type="text" class="form-control" name="file.createDate"/>
                                <span class="input-group-addon"><i class="fa fa-exchange"></i></span>
                                <input type="text" class=" form-control" name="file.modifyDate"/>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-offset-3 col-md-9">
                        <button class="btn btn-info" type="submit">
                            开始搜索
                            <i class="ace-icon fa fa-search"></i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
<script src='assets/js/jquery.min.js'></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/excanvas.min.js"></script>
<script src="assets/js/jquery-ui.custom.min.js"></script>
<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="assets/js/chosen.jquery.min.js"></script>
<script src="assets/js/fuelux/fuelux.spinner.min.js"></script>
<script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="assets/js/date-time/bootstrap-timepicker.min.js"></script>
<script src="assets/js/date-time/moment.min.js"></script>
<script src="assets/js/date-time/daterangepicker.min.js"></script>
<script src="assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script src="assets/js/bootstrap-colorpicker.min.js"></script>
<script src="assets/js/jquery.inputlimiter.1.3.1.min.js"></script>
<script src="assets/js/jquery.maskedinput.min.js"></script>
<script src="assets/js/bootstrap-tag.min.js"></script>
<script src="assets/js/ace-elements.min.js"></script>
<script src="assets/js/ace.min.js"></script>
<script type="text/javascript">
    jQuery(function ($) {
        $('.input-daterange').datepicker({
            format: 'yyyy-mm-dd',
            autoclose: true
        });
    });
</script>
</body>
</html>
