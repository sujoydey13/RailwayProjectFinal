package com.quinbay.search.service;

import java.util.List;

public interface SearchService {
    List<Long> doSearchTrains(String from,String to);
    void insertRoute(Long id,String start,String end);
}
