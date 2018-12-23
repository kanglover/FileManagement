package com.dao.impl;

import com.dao.FileDao;
import com.entity.PageDTO;
import com.entity.PageResultDTO;
import com.entity.UploadFile;
import org.apache.commons.beanutils.ConvertUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Component
public class FileDaoImpl implements FileDao {
    @Resource(name="hibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    @Override
    public Integer fileUpload(UploadFile file) {
        return (Integer) hibernateTemplate.save(file);
    }

    @Override
    public PageResultDTO findFiles(PageDTO pageDTO) {
        PageResultDTO dto = new PageResultDTO();
        String hql = "from UploadFile";
        if(null != pageDTO.getFolderId()) {
            hql += " where folder = " + pageDTO.getFolderId();
        }
        Session session = hibernateTemplate.getSessionFactory()
                .openSession();
        Query query = session.createQuery(hql);
        query.setFirstResult(pageDTO.getStartIndex());
        query.setMaxResults(pageDTO.getPageSize());
        dto.setDatas(query.list());


        List<UploadFile> files = (ArrayList<UploadFile>) hibernateTemplate.find(hql);
        pageDTO.setTotalCount(files.size());
        Double page = Math.ceil(files.size() / 10.0);
        pageDTO.setTotalPage(page.intValue());
        dto.setPageDTO(pageDTO);
        return dto;
    }

    @Override
    public ArrayList<UploadFile> turnPage(PageDTO pageDTO) {
        Session session = hibernateTemplate.getSessionFactory()
                .openSession();
        String hql = "from UploadFile";
        Query query = session.createQuery(hql);
        query.setFirstResult(pageDTO.getStartIndex());
        query.setMaxResults(pageDTO.getPageSize());
        ArrayList<UploadFile> files = (ArrayList<UploadFile>)query.list();
        return files;
    }

    @Override
    public List<UploadFile> findMoreFile(String[] ids) {
        String hql = "from UploadFile where fileId in (:ids)";
        Session session = hibernateTemplate.getSessionFactory()
                .openSession();
        Query query = session.createQuery(hql);
        Integer[] filesId = (Integer[]) ConvertUtils.convert(ids, Integer.class);
        query.setParameterList("ids", filesId);
        return (List<UploadFile>) query.list();
    }


    @Override
    public UploadFile findFile(Integer fileId) {
        return hibernateTemplate.get(UploadFile.class, fileId);
    }

    @Override
    public void deleteFile(Integer fileId) {
        UploadFile file = hibernateTemplate.get(UploadFile.class, fileId);
        hibernateTemplate.delete(file);
    }

    @Override
    public void updateFile(UploadFile file) {
        hibernateTemplate.update(file);
    }

    @Override
    public ArrayList<UploadFile> searchFiles(UploadFile file) throws Exception{
        Session session = hibernateTemplate.getSessionFactory()
                .openSession();
        String hql = "from UploadFile where fileName like :fileName " +
                "and theme like :theme " +
                "and keywords like :keywords ";

        if(null != file.getCreator()) {
            hql += "and creator = " + file.getCreator().getEid();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if(null != file.getCreateDate()) {
            hql += "and createDate >= " +  format.format(file.getCreateDate());
        }
        if(null != file.getModifyDate()) {
            hql += "and createDate >= " +  format.format(file.getModifyDate());
        }
        Query query = session.createQuery(hql);
        query.setParameter("fileName", "%" + file.getFileName() + "%");
        query.setParameter("theme", "%" + file.getTheme() + "%");
        query.setParameter("keywords", "%" + file.getKeywords() + "%");

//        query.setFirstResult(0);
//        query.setMaxResults(3);
        return (ArrayList<UploadFile>) query.list();
    }

}
