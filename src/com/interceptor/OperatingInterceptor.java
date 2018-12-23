package com.interceptor;

import com.entity.Employee;
import com.entity.History;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.service.HistoryService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.Parameter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OperatingInterceptor extends AbstractInterceptor {
    @Resource
    private HistoryService historyService;
    private static final Map<String, String> map = new HashMap<String, String>() {
        {
            put("findFile", "查看");
            put("createFile", "新建");
            put("updateFile", "重命名");
            put("fileUpload", "上传");
            put("fileDownload", "下载");
        }
    };

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        actionInvocation.invoke();

        String method = actionInvocation.getProxy().getMethod();
        Map<String, Parameter> parameters = actionInvocation.getInvocationContext().getParameters();
        History history = new History();
        if (null != map.get(method)) {
            HttpServletRequest request = ServletActionContext.getRequest();
            Integer fileId;
            if(parameters.get("file.fileId").getValue() != null) {
                fileId = Integer.parseInt(parameters.get("file.fileId").toString());
            } else {
                fileId = (Integer) request.getAttribute("id");
            }
            history.setFileId(fileId);
            history.setOperate(map.get(method));

            Employee e = (Employee) request.getSession().getAttribute("employee");
            history.setOperator(e);
            history.setOperateDate(new Date());
            this.historyService.saveHistory(history);
        }
        return null;

    }
}
