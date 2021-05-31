package com.kmend.techchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmend.techchallenge.model.Region;
import com.kmend.techchallenge.model.User;
import com.kmend.techchallenge.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }
    
    public List<User> listByFilters(Double minimalSpend, Region region) {
    	return userRepository.findByFilters(minimalSpend, region == null ? Region.values() : new Region[]{region});
    }

}
