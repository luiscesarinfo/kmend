package com.kmend.techchallenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kmend.techchallenge.model.Region;
import com.kmend.techchallenge.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.spend >= ?1 AND u.region IN ?2")
	List<User> findByFilters(Double minimalSpend, Region[] regions);
}
