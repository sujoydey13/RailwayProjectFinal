package com.quinbay.search.controller;

import com.quinbay.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("")
    public List<Long> searchTrains(@RequestParam String fromLocation, @RequestParam String toLocation){
        return searchService.doSearchTrains(fromLocation,toLocation);
    }

    @GetMapping("/insert")
    public void insert(@RequestParam Long id,@RequestParam String start,@RequestParam String end){
        searchService.insertRoute(id,start,end);
    }
}
