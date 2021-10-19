package ru.lis154.restServiceStock.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lis154.restServiceStock.entity.Notification;
import ru.lis154.restServiceStock.entity.ShareEntity;

@RestController
@RequestMapping("/api")
public interface NotificationRepository extends CrudRepository<Notification, Long> {
}
