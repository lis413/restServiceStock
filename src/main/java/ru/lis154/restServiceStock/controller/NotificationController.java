package ru.lis154.restServiceStock.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lis154.restServiceStock.entity.Notification;
import ru.lis154.restServiceStock.repository.NotificationRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificationController {
    @Autowired
    NotificationRepository notificationRepository;

    public List<Notification> getAllNotification(){
        return (List<Notification>) notificationRepository.findAll();
    }
}
