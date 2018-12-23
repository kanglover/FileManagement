package com.dao.impl;

import com.dao.FolderDao;
import com.entity.Folder;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.ArrayList;

@Component
public class FolderDaoImpl implements FolderDao {
    @Resource(name="hibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    @Override
    public void addFolder(Folder folder) {
        hibernateTemplate.save(folder);
    }

    @Override
    public ArrayList<Folder> findFolders() {
        String hql = "from Folder";
        ArrayList<Folder> folders = (ArrayList<Folder>)hibernateTemplate.find(hql);
        return folders;
    }

    @Override
    public Folder findFolder(Integer folderId) {
        return hibernateTemplate.get(Folder.class, folderId);
    }
}
