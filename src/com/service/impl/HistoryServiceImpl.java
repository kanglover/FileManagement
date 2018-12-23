package com.service.impl;

import com.dao.HistoryDao;
import com.entity.History;
import com.service.HistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {
    @Resource
    private HistoryDao historyDao;

    @Override
    public void saveHistory(History history) {
        this.historyDao.saveHistory(history);
    }

    @Override
    public List<History> findHistories(String[] files) {
        return this.historyDao.findHistories(files);
    }
}
