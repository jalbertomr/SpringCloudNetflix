package com.bext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootHolaMundoApplication {

	public static void main(String[] args){
		SpringApplication.run(SpringBootHolaMundoApplication.class, args);
	}
}
