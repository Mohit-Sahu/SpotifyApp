package com.cognizant.mohit.Music_List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@org.springframework.cloud.openfeign.EnableFeignClients
public class MusicListApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicListApplication.class, args);
	}

}
