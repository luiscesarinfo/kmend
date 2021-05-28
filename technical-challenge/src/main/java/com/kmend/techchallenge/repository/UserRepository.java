package com.kmend.techchallenge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kmend.techchallenge.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
