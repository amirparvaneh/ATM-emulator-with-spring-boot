package com.esg.armenia.atm.repository;

import com.esg.armenia.atm.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findOneByUsername(String username);

    User findOne(Integer valueOf);
}
