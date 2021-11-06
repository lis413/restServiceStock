package ru.lis154.restServiceStock.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;
import ru.lis154.restServiceStock.entity.ShareEntity;
import ru.lis154.restServiceStock.entity.UserSec;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserSec, Long> {

    public Optional<UserSec> findByEmail(String email);

}
