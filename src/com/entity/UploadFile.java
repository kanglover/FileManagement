package com.entity;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "upload_file")
public class UploadFile implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "fid",nullable = false,unique = true)
	private Integer fileId;

    @Column(name = "file_name",nullable = false,unique=false)
	private String fileName;

    @Column(name = "file_size",nullable = false)
	private String fileSize;

    @Column(name = "file_type",nullable = false)
	private String fileType;

    @Column(name = "save_path",nullable = false)
	private String savePath;

    @OneToOne
    @JoinColumn(name = "creator",referencedColumnName = "eid")
	private Employee creator;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date", nullable = true)
	private Date createDate;

    @OneToOne
    @JoinColumn(name = "modifier",referencedColumnName = "eid")
    private Employee modifier;

    @Column(name = "modify_date", nullable = true)
    private Date modifyDate;

    @Column(name = "theme", nullable = false)
	private String theme;

    @Column(name = "keywords", nullable = true)
	private String keywords;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public Employee getCreator() {
        return creator;
    }

    public void setCreator(Employee creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Employee getModifier() {
        return modifier;
    }

    public void setModifier(Employee modifier) {
        this.modifier = modifier;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}