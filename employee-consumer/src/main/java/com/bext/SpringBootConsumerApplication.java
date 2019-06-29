package com.bext;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.bext.controllers.ConsumerControllerClient;

@SpringBootApplication

public class SpringBootConsumerApplication {

	public static void main(String[] args) throws RestClientException, IOException{
		ApplicationContext ctx = SpringApplication.run( SpringBootConsumerApplication.class, args);

		ConsumerControllerClient consumerControllerClient = ctx.getBean( ConsumerControllerClient.class);
		System.out.println( consumerControllerClient);
		consumerControllerClient.getEmployee();
	}

	@Bean
	public ConsumerControllerClient consumerControllerClient() {
		return new ConsumerControllerClient();
	}
}