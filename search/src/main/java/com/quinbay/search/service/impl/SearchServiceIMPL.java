package com.quinbay.search.service.impl;

import com.quinbay.search.entity.TrainRoute;
import com.quinbay.search.repository.TrainRouteRepository;
import com.quinbay.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceIMPL implements SearchService {

    @Autowired
    private TrainRouteRepository trainRouteRepository;

    @Override
    public void insertRoute(Long id, String start, String end) {
        System.out.println("insert "+start+" "+end);
        Map<String,Integer> map = new HashMap<>();
        map.put(start,0);
        map.put(end,250);
        TrainRoute tr = new TrainRoute();
        tr.setTrainId(id);
        tr.setStations(map);
        System.out.println(tr.toString());
        trainRouteRepository.save(tr);
    }

    @Override
    public List<Long> doSearchTrains(String from, String to) {
        List<Long> response  = new ArrayList<>();
        from  = from.toLowerCase();
        to = to.toLowerCase();
        System.out.println(from+" "+to);
        List<TrainRoute> ans = trainRouteRepository.getTrains(from,to);
        for(TrainRoute tr : ans){
            response.add(tr.getTrainId());
        }
        return response;
    }
}
