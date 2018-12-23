package com.dao;

import com.entity.Folder;

import java.util.ArrayList;

public interface FolderDao {
    void addFolder(Folder folder);

    ArrayList<Folder> findFolders();

    Folder findFolder(Integer folderId);
}
