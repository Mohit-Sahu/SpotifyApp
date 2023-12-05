/**
 * 
 */
package com.cognizant9.AuthenticationService.kafka;

import java.io.IOException;
import java.util.List;

/**
 * @author mohit
 *
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant9.AuthenticationService.entity.User;
import com.cognizant9.AuthenticationService.repository.UserRepo;
import com.cognizant9.AuthenticationService.service.UserService;
import com.cognizant9.UserProfileService.entity.UserDetails;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Consumer {
	
	@Autowired
	UserService userService;//for consuming data from kafka and register the user
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(UserDetails user){
        LOGGER.info(String.format("Json message recieved -> %s", user.toString()));
        userService.registerUser(user);//user registeration using kafka
    }
	    
	    

}

