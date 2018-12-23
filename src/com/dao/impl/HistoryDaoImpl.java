package com.dao.impl;

import com.dao.HistoryDao;
import com.entity.History;
import org.apache.commons.beanutils.ConvertUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

@Component
public class HistoryDaoImpl implements HistoryDao {
    @Resource(name="hibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    @Override
    public void saveHistory(History history) {
        hibernateTemplate.save(history);
    }

    @Override
    public List<History> findHistories(String[] files) {
        String hql = "from History where fileId in (:files)";
        Session session = hibernateTemplate.getSessionFactory()
                .openSession();
        Query query = session.createQuery(hql);
        Integer[] filesId = (Integer[]) ConvertUtils.convert(files, Integer.class);
        query.setParameterList("files", filesId);
        return (List<History>) query.list();
    }
}
