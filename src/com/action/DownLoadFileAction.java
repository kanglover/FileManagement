package com.action;

import com.entity.UploadFile;
import com.opensymphony.xwork2.ActionSupport;
import com.service.FileService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


@Controller
@Scope("prototype")
public class DownLoadFileAction extends ActionSupport {
    @Resource
    private FileService fileService;
    private UploadFile file;
    private String downloadFileName;

    private InputStream inputStreamAll;
    private String fileNameforAll;

    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getFileNameforAll() {
        String formatDate =new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        //添加文件名的后缀
        fileNameforAll = formatDate + ".zip";
        return fileNameforAll;
    }

    public InputStream getInputStreamAll() throws Exception {
        return inputStreamAll;
    }

    public void setInputStreamAll(InputStream inputStreamAll) throws Exception {
        this.inputStreamAll = inputStreamAll;
    }


    public String downloadMoreFile() {
        List<UploadFile> files = fileService.findMoreFile(ids);
        File zipFile = new File(ServletActionContext.getServletContext()//定义所要输入文件的zip文件
                .getRealPath("/uploadFile/zipFile.zip"));

        try {
            if (zipFile.exists()) {
                zipFile.createNewFile();
            }

            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
            for (UploadFile file : files) {
                String fileName = file.getFileName();
                String prefix = ServletActionContext.getServletContext().getRealPath("/uploadFile/" + file.getFolder().getSavePath());
                File file1 = new File(prefix + "/" + fileName);

                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    byte[] buffer = new byte[1024 * 10];
                    fis = new FileInputStream(file1);
                    bis = new BufferedInputStream(fis, buffer.length);
                    int read = 0;
                    zos.putNextEntry(new ZipEntry(fileName));
                    while ((read = bis.read(buffer, 0, buffer.length)) != -1) {
                        zos.write(buffer, 0, read);
                    }
                    zos.closeEntry();
                } finally {
                    fis.close();
                    bis.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            this.inputStreamAll = new FileInputStream(zipFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }


    public UploadFile getFile() {
        return file;
    }

    public void setFile(UploadFile file) {
        this.file = file;
    }

    // 获取文件名
    public String getDownloadFileName() throws Exception {
        file = fileService.findFile(file.getFileId());
        downloadFileName = java.net.URLEncoder
                .encode(file.getFileName(), "utf-8");
        return downloadFileName;
    }

    // 获取下载的流
    public InputStream getInputStream() throws Exception {
        String name = this.getDownloadFileName();
        String filePath = ServletActionContext.getServletContext().getRealPath("/uploadFile/" + file.getFolder().getSavePath());
        File saveFile = new File(filePath, file.getFileName());
        InputStream is = new FileInputStream(saveFile);
        return is;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
