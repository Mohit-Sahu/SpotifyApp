/**
 * 
 */
package com.cognizant9.UserProfileService.kafka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cognizant9.UserProfileService.entity.User;

/**
 * @author mohit
 *
 */
@Service
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Autowired
    private KafkaTemplate<String, List<User>> kafkaTemplatelist;

    private static final String TOPIC = "user-profile-topic"; // Your Kafka topic

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }

	

	/**
	 * @param list
	 */
	public void sendMessagelist(List<User> list) {
		// TODO Auto-generated method stub
		kafkaTemplatelist.send(TOPIC, list);
	}
}

