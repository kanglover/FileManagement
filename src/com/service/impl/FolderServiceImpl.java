package com.service.impl;

import com.dao.FolderDao;
import com.entity.Folder;
import com.service.FolderService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;

@Service
@Transactional
public class FolderServiceImpl implements FolderService {
    @Resource
    private FolderDao folderDao;

    @Override
    public void addFolder(Folder folder) {
        //设置上传文件目录  
        if (folder.getParentFolder().getFolderId().equals(0)) {
            //如果前台不输入上级文件夹，就赋空
            folder.setParentFolder(null);
            folder.setSavePath("/" + folder.getName());
        } else {
            Folder parent = findFolder(folder.getParentFolder().getFolderId());
            folder.setSavePath(parent.getSavePath() + "/" + folder.getName());
        }

        String filePath = ServletActionContext.getServletContext().getRealPath("/uploadFile" + folder.getSavePath());
        File saveFile = new File(filePath);
        try {
            if (saveFile.isDirectory()) {
                System.out.println("the directory is exists!");
            } else {
                saveFile.mkdir();
                System.out.println("新建目录成功");
                folderDao.addFolder(folder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Folder> findFolders() {
        ArrayList<Folder> folders = folderDao.findFolders();
        JSONArray json = new JSONArray();
        for (int i = 0; i < folders.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", folders.get(i).getFolderId());
            if (null == folders.get(i).getParentFolder()) {
                jsonObject.put("pId", 0);
            } else {
                jsonObject.put("pId", folders.get(i).getParentFolder().getFolderId());
            }
            jsonObject.put("name", folders.get(i).getName());
            json.put(jsonObject);
        }

        ServletActionContext.getRequest().getSession().setAttribute("data", json.toString());
        return folders;
    }

    @Override
    public Folder findFolder(Integer folderId) {
        return folderDao.findFolder(folderId);
    }


}
