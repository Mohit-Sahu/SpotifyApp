/**
 * 
 */
package com.cognizant9.AuthenticationService.kafka;

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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Consumer {
	
	 private static final String TOPIC = "user-profile-topic";
	 
	 
	 Logger logger = LoggerFactory.getLogger(Consumer.class);
	 
	 @Autowired
	 private UserRepo userDao;
	 
	 
	 
	 
        
	 
	 
	    @KafkaListener(topics = TOPIC, groupId = "authentication-group")
	    public void consumeUserProfileEvent(String message) {
	        // Process the received message from the UserProfileService
	        System.out.println("Received message in AuthenticationService: " + message);
	        // Perform authentication-related logic here
	        logger.info("consumes message "+message);
	        ObjectMapper objectMapper = new ObjectMapper();
	        try {
	            // Convert JSON string to List
	            List<String> stringList = objectMapper.readValue(message, new TypeReference<List<String>>() {});
	            // Print the resulting List
	            System.out.println("Converted List:");
	            for (String element : stringList) {
	                System.out.println(element);
	                
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}

