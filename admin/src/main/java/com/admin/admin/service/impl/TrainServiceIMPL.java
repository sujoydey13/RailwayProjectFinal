package com.admin.admin.service.impl;

import com.admin.admin.client.ClientService;
import com.admin.admin.dto.AddingTrainsDTO;
import com.admin.admin.entity.Trains;
import com.admin.admin.repository.TrainRepository;
import com.admin.admin.service.TrainSercive;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@EnableFeignClients
@Service
public class TrainServiceIMPL implements TrainSercive {
    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private ClientService clientService;

    @Override
    public void addTrains(AddingTrainsDTO addingTrainsDTO) {
    //    AddingTrainsDTO response = new AddingTrainsDTO();
    //   Trains trainDetails=new Trains();
    //   BeanUtils.copyProperties(addingTrainsDTO, trainDetails);
    //  trainRepository.save(trainDetails);
        clientService.addTrains(addingTrainsDTO);
    //    System.out.println(trainDetails.toString());
      // return new ResponseEntity<>(response, HttpStatus.OK);
  //      clientService.addTrains(addingTrainsDTO);
    }
}
