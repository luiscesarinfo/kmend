package com.kmend.techchallenge.config;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.math3.util.Precision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.kmend.techchallenge.model.Region;
import com.kmend.techchallenge.model.User;
import com.kmend.techchallenge.repository.UserRepository;

@Component
public class DataLoader implements InitializingBean {

    private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    private Environment environment;

    @Autowired(required = true)
    @Qualifier(value="userRepository")
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info(Arrays.asList(environment.getDefaultProfiles()).toString());
        for (int i = 0; i < 500; i++) {
			userRepository.save(createAleatoryUser());
		}
    }

	private User createAleatoryUser() {
		Integer birthday = (int) ((Math.random() * ((12 - 1) + 1)) + 1);
		Double spend = Precision.round(((Math.random() * ((5000 - 0) + 0)) + 0), 2) ;
		Region region = Region.values()[new Random().nextInt(Region.values().length)];

		return new User(birthday, spend, region);
	}
}
