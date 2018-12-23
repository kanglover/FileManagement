package com.action;

import com.entity.*;
import com.opensymphony.xwork2.ActionSupport;
import com.service.EmployeeService;
import com.service.FileService;
import com.service.FolderService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Scope("prototype")
public class FileAction extends ActionSupport {
    private File upload;
    private String uploadContentType;
    private String uploadFileName;

    private UploadFile file;

    private ArrayList<UploadFile> files;

    private List<Employee> employees;

    private PageDTO pageDTO = new PageDTO();

    private PageResultDTO pageResultDTO = new PageResultDTO();

    private String ids;

    private Integer id = 0;

    @Resource
    private FileService fileService;

    @Resource
    private FolderService folderService;

    @Resource
    private EmployeeService employeeService;



    public String fileUpload() {
        //设置上传文件目录
        Folder folder = folderService.findFolder(file.getFolder().getFolderId());

        String filePath = ServletActionContext.getServletContext().getRealPath("/uploadFile/" + folder.getSavePath());
        //判断上传文件是否为空
        if (upload != null) {
            //设置目标文件（根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例）
            File saveFile = new File(filePath, uploadFileName);
            // 判断上传目录是否存在
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            if(!saveFile.exists()) {
                try {
                    //上传文件
                    FileUtils.copyFile(upload, saveFile);


                    file.setFileName(uploadFileName);
                    file.setFileType(readableFileType(uploadContentType));
                    Long fileSize = upload.length();
                    file.setFileSize(readableFileSize(fileSize));
                    preSave(file);
                    id = fileService.fileUpload(file);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
        return SUCCESS;
    }

    public String createFile() {
        Folder folder = folderService.findFolder(file.getFolder().getFolderId());
        file.setFileName(file.getFileName() + "." + file.getFileType());
        String filePath = ServletActionContext.getServletContext().getRealPath("/uploadFile/" + folder.getSavePath());
        File saveFile = new File(filePath, file.getFileName());
        // 判断上传目录是否存在
        if (!saveFile.getParentFile().exists()) {
            saveFile.getParentFile().mkdirs();
        }

        if(!saveFile.exists()) {
            try {
                saveFile.createNewFile();
                file.setFileSize("0 KB");
                preSave(file);
                id = fileService.fileUpload(file);
            }  catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return SUCCESS;
    }

    public String findFiles() {
        PageResultDTO dto = fileService.findFiles(pageDTO);
        files = (ArrayList<UploadFile>) dto.getDatas();
        pageDTO = dto.getPageDTO();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getSession().setAttribute("files", files);
        return SUCCESS;
    }

    public String turnPage() {
        if (pageDTO.getCurrentPage() > 0) {
            files = fileService.turnPage(pageDTO);
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getSession().setAttribute("files", files);
        return SUCCESS;
    }

    public String preSearch() {
        employees = employeeService.findEmployees();
        return SUCCESS;
    }

    public String searchFiles() throws Exception{
        files = fileService.searchFiles(file);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getSession().setAttribute("files", files);
        return SUCCESS;
    }

    public String findFile() {
        pageDTO = new PageDTO();
        file = fileService.findFile(file.getFileId());
        return SUCCESS;
    }

    public String updateFile() {
        fileService.updateFile(file);
        return SUCCESS;
    }

    public String deleteFile() {
        fileService.deleteFile(file.getFileId());
        return SUCCESS;
    }

    public String deleteFiles() {
        fileService.deleteFiles(ids);
        return SUCCESS;
    }


    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public UploadFile getFile() {
        return file;
    }

    public void setFile(UploadFile file) {
        this.file = file;
    }

    public ArrayList<UploadFile> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<UploadFile> files) {
        this.files = files;
    }

    public PageDTO getPageDTO() {
        return pageDTO;
    }

    public void setPageDTO(PageDTO pageDTO) {
        this.pageDTO = pageDTO;
    }

    public PageResultDTO getPageResultDTO() {
        return pageResultDTO;
    }

    public void setPageResultDTO(PageResultDTO pageResultDTO) {
        this.pageResultDTO = pageResultDTO;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static String readableFileSize(long size) {
        if (size <= 0) return "0";
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    public static String readableFileType(String ContentType) {
        String fileType = "";
        switch (ContentType) {
            case "application/msword":
                fileType =  "doc";
                break;
            case "application/pdf":
                fileType =  "pdf";
                break;
            case "image/jpeg":
                fileType =  "jpeg";
                break;
            case "image/gif":
                fileType =  "gif";
                break;
            case "text/plain":
                fileType =  "txt";
                break;
            case "application/vnd.ms-excel":
                fileType =  "xls";
                break;
            case "application/vnd.ms-powerpoint":
                fileType =  "ppt";
                break;
        }
        return fileType;
    }

    public void preSave(UploadFile file) {
        HttpServletRequest request = ServletActionContext.getRequest();
        Employee e = (Employee) request.getSession().getAttribute("employee");
        file.setModifyDate(new Date());
        file.setModifier(e);
        file.setCreateDate(new Date());
        file.setCreator(e);
    }


}
