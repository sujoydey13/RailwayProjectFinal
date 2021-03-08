package com.admin.admin.contoller;

import com.admin.admin.dto.AddingTrainsDTO;
import com.admin.admin.service.TrainSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/add")
public class TrainController {
    @Autowired
    private TrainSercive trainSercive;
    @PostMapping("")
    public void addTrains(@RequestBody AddingTrainsDTO addingTrainsDTO){
         trainSercive.addTrains(addingTrainsDTO);
    }

}
