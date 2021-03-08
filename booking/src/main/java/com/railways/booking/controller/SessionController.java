package com.railways.booking.controller;

import com.railways.booking.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/setSession")
    void addSession(@RequestParam String userName,@RequestParam String sessionId,@RequestParam String isLoggedIn){
        sessionService.updateSession(userName,sessionId,isLoggedIn);
    }

    @PostMapping("/deleteSession")
    void deleteSession(@RequestParam String sessionid){
        sessionService.deleteSession(sessionid);
    }

    @KafkaListener(topics = "sessions-kafka")
    public void listenMessage(Message<String> message){
        String userName = message.getHeaders().get("kafka_receivedMessageKey").toString();
        String[] arr = message.getPayload().split(" ");
        if(arr.length == 2){
            sessionService.updateSession(userName,arr[0],arr[1]);
        }
        else{
            sessionService.deleteSession(arr[0]);
        }
    }
}
