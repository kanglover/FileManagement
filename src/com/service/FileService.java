package com.service;

import com.entity.PageDTO;
import com.entity.PageResultDTO;
import com.entity.UploadFile;

import java.util.ArrayList;
import java.util.List;

public interface FileService {
    Integer fileUpload(UploadFile file);

    PageResultDTO findFiles(PageDTO pageDTO);

    ArrayList<UploadFile> turnPage(PageDTO pageDTO);

    UploadFile findFile(Integer fileId);

    void deleteFile(Integer fileId);

    void updateFile(UploadFile file);

    ArrayList<UploadFile> searchFiles(UploadFile file) throws Exception;

    void deleteFiles(String ids);

    List<UploadFile> findMoreFile(String ids);
}
