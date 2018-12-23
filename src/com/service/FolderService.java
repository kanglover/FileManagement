package com.service;

import com.entity.Folder;

import java.util.ArrayList;

public interface FolderService {
    void addFolder(Folder folder);

    ArrayList<Folder> findFolders();

    Folder findFolder(Integer folderId);
}
