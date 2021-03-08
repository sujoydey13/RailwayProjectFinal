package com.admin.admin.client;

import com.admin.admin.dto.AddingTrainsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "Search-client",url="10.177.68.53:8082")
public interface ClientService {

    @RequestMapping(method = RequestMethod.POST,path = "/admin/addTrain")
    List<Long> addTrains(@RequestBody AddingTrainsDTO newTrain);
}
