package com.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "upload_file")
public class UploadFile implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "fid",nullable = false,unique = true)
	private Integer fileId;

    @Column(name = "file_name",nullable = false,unique=true)
	private String fileName;

    @Column(name = "file_size",nullable = false)
	private String fileSize;

    @Column(name = "file_type",nullable = false)
	private String fileType;

    @OneToOne(targetEntity=Folder.class, cascade={CascadeType.REFRESH})
    @JoinColumn(name = "folder",referencedColumnName = "folder_id")
    private Folder folder;

    @OneToOne(targetEntity=Employee.class, cascade={CascadeType.REFRESH})
    @JoinColumn(name = "creator",referencedColumnName = "eid")
	private Employee creator;

    @Column(name = "create_date", nullable = true)
	private Date createDate;

    @OneToOne(targetEntity=Employee.class, cascade={CascadeType.REFRESH})
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

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}