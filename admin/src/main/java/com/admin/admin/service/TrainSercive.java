package com.admin.admin.service;

import com.admin.admin.dto.AddingTrainsDTO;
import org.springframework.http.ResponseEntity;

public interface TrainSercive {
    void addTrains(AddingTrainsDTO addingTrainsDTO);
}
