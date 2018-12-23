package com.dao;

import com.entity.History;

import java.util.List;

public interface HistoryDao {
    void saveHistory(History history);

    List<History> findHistories(String[] files);
}
