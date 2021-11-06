package ru.lis154.restServiceStock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import ru.lis154.restServiceStock.entity.UserSec;
import ru.lis154.restServiceStock.kafka.KafkaTemplate2;

@Service
public class ProducerService {

    private final KafkaTemplate2<String, UserSec> kafkaTemplate;

    @Autowired
    public ProducerService(KafkaTemplate2<String, UserSec> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(UserSec user) {
        System.out.println("Producing the message: " + user);
        ListenableFuture<SendResult<String, UserSec>> future = kafkaTemplate.send("messages",  user);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }
}