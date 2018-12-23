package com.service.impl;

import com.dao.FileDao;
import com.entity.*;
import com.service.FileService;
import com.service.FolderService;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FileServiceImpl implements FileService {
    @Resource
    private FileDao fileDao;
    @Resource
    private FolderService folderService;

    @Override
    public Integer fileUpload(UploadFile file) {
        return fileDao.fileUpload(file);
    }

    @Override
    public PageResultDTO findFiles(PageDTO pageDTO) {
        pageDTO.setStartIndex(0);
        return fileDao.findFiles(pageDTO);
    }

    @Override
    public ArrayList<UploadFile> turnPage(PageDTO pageDTO) {
        pageDTO.setStartIndex((pageDTO.getCurrentPage() - 1) * pageDTO.getPageSize());
        return fileDao.turnPage(pageDTO);
    }

    @Override
    public UploadFile findFile(Integer fileId) {
        return fileDao.findFile(fileId);
    }

    @Override
    public void deleteFile(Integer fileId) {
        UploadFile file = this.findFile(fileId);
        Folder folder = folderService.findFolder(file.getFolder().getFolderId());
        String filePath = ServletActionContext.getServletContext().getRealPath("/uploadFile/" + folder.getSavePath());
        File saveFile = new File(filePath, file.getFileName());
        //删文件
        saveFile.delete();
        //删数据
        fileDao.deleteFile(fileId);
    }

    @Override
    public void updateFile(UploadFile file) {
        UploadFile oldFile = this.findFile(file.getFileId());
        String filePath = ServletActionContext.getServletContext().getRealPath("/uploadFile/" + oldFile.getFolder().getSavePath());

        File saveFile = new File(filePath, oldFile.getFileName());
        File newFile = new File(saveFile.getParent() + File.separator + file.getFileName());
        saveFile.renameTo(newFile);
        oldFile.setFileName(file.getFileName());
        HttpServletRequest request = ServletActionContext.getRequest();
        Employee e = (Employee) request.getSession().getAttribute("employee");
        oldFile.setModifyDate(new Date());
        oldFile.setModifier(e);
        fileDao.updateFile(oldFile);
    }

    @Override
    public ArrayList<UploadFile> searchFiles(UploadFile file) throws Exception{
        return fileDao.searchFiles(file);
    }

    @Override
    public void deleteFiles(String ids) {
        String[] id = ids.split(",");
        for(String fileId : id) {
            deleteFile(Integer.parseInt(fileId));
        }
    }

    @Override
    public List<UploadFile> findMoreFile(String ids) {
        return fileDao.findMoreFile(ids.split(","));
    }
}
