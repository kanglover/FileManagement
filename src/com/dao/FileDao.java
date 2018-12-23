package com.dao;

import com.entity.PageDTO;
import com.entity.PageResultDTO;
import com.entity.UploadFile;

import java.util.ArrayList;
import java.util.List;

public interface FileDao {
    Integer fileUpload(UploadFile file);

    PageResultDTO findFiles(PageDTO pageDTO);

    UploadFile findFile(Integer fileId);

    void deleteFile(Integer fileId);

    void updateFile(UploadFile file);

    ArrayList<UploadFile> searchFiles(UploadFile file) throws Exception;

    ArrayList<UploadFile> turnPage(PageDTO pageDTO);

    List<UploadFile> findMoreFile(String[] ids);
}
