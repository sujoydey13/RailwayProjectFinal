package com.quinbay.search.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Map;

@Document
@Data
public class TrainRoute {
    @MongoId
    private Long trainId;
    private Map<String,Integer> stations;
}
