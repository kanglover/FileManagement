package com.action;

import com.entity.History;
import com.opensymphony.xwork2.ActionSupport;
import com.service.HistoryService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
public class HistoryAction extends ActionSupport {
    List<History> histories = new ArrayList<>();
    String files;
    @Resource
    private HistoryService historyService;

    public String execute() {
        histories = historyService.findHistories(files.split(","));
        return SUCCESS;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }
}
