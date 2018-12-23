package com.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "folder")
public class Folder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "folder_id",nullable = false,unique = true)
    private Integer folderId;

    @Column(name = "name",nullable = true,unique=true)
    private String name;

    @Column(name = "keywords", nullable = true)
    private String keywords;

    @Column(name = "savePath", nullable = true)
    private String savePath;

    @ManyToOne(targetEntity=Folder.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id",referencedColumnName="folder_id")
    private Folder parentFolder;

    @OneToMany(targetEntity=Folder.class, cascade={CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Set<Folder> childFolders = new HashSet<>();

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public Folder getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(Folder parentFolder) {
        this.parentFolder = parentFolder;
    }

    public Set<Folder> getChildFolders() {
        return childFolders;
    }

    public void setChildFolders(Set<Folder> childFolders) {
        this.childFolders = childFolders;
    }
}
