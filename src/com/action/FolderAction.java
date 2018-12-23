package com.action;

import com.entity.Folder;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.FolderService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import java.util.ArrayList;


@Controller
@Scope("prototype")
public class FolderAction extends ActionSupport implements ModelDriven<Folder> {
    Folder folder = new Folder();
    ArrayList<Folder> folders = new ArrayList<>();

    @Resource
    private FolderService folderService;

    public String addFolder() {
        folderService.addFolder(folder);
        return SUCCESS;
    }

    public String findFolders() {
        folders = folderService.findFolders();
        ServletActionContext.getRequest().getSession().setAttribute("folders", folders);
        return SUCCESS;
    }

    @Override
    public Folder getModel() {
        return this.folder;
    }

    public ArrayList<Folder> getFolders() {
        return folders;
    }

    public void setFolders(ArrayList<Folder> folders) {
        this.folders = folders;
    }
}
