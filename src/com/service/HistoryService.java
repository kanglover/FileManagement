package com.service;

import com.entity.History;

import java.util.List;

public interface HistoryService {
    void saveHistory(History history);

    List<History> findHistories(String[] files);
}
