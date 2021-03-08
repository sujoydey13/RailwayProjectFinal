package com.quinbay.search.repository;

import com.quinbay.search.entity.TrainRoute;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TrainRouteRepository extends MongoRepository<TrainRoute,Long> {

    @Query(value = "{'stations.?0':{$exists:true}, 'stations.?1':{$exists:true}}")
    List<TrainRoute> getTrains(String fl,String tl);

}
