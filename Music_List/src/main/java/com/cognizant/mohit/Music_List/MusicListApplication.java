package com.cognizant.mohit.Music_List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MusicListApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicListApplication.class, args);
	}

}
