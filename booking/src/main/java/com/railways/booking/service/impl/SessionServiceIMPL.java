package com.railways.booking.service.impl;

import com.railways.booking.entity.Sessions;
import com.railways.booking.repository.SessionRepository;
import com.railways.booking.service.SessionService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.Duration;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;

@CrossOrigin
@Service
public class SessionServiceIMPL implements SessionService {
    @Autowired
    private SessionRepository sessionRepository;

//    static Properties props = new Properties();
//    static{
//        props.setProperty("bootstrap.servers", "localhost:9092");
//        props.setProperty("group.id", "test");
//        props.setProperty("enable.auto.commit", "true");
//        props.setProperty("auto.commit.interval.ms", "1000");
//        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//    }
//
//    static KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
//    static{
//        consumer.subscribe(Arrays.asList("sessions-kafka"));
//    }
//    static {
//            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
//            for (ConsumerRecord<String, String> record : records)
//                System.out.printf(" key = %s, value = %s%n",  record.key(), record.value());
//        }


    @Override
    public void updateSession(String userName, String sessionId,String isLoggedIn) {
            Sessions sessions = new Sessions();
            sessions.setSessionID(sessionId);
            sessions.setIsLoggedIn(isLoggedIn);
            sessions.setUserName(userName);
            sessionRepository.save(sessions);
    }

    @Override
    @Transactional
    public void deleteSession(String uID) {
        try{
            sessionRepository.deleteSession(uID);
        }
        catch (Exception e){

        }
    }

}
