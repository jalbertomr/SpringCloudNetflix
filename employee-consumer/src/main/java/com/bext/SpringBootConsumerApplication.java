package com.bext;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.bext.controllers.ConsumerControllerClient;
import com.bext.model.Info;

@SpringBootApplication

public class SpringBootConsumerApplication {
	
	public static void main(String[] args) throws RestClientException, IOException{
		ApplicationContext ctx = SpringApplication.run( SpringBootConsumerApplication.class, args);

		ConsumerControllerClient consumerControllerClient = ctx.getBean( ConsumerControllerClient.class);
		System.out.println( consumerControllerClient);
		System.out.println( "server.port:" + ctx.getEnvironment().getProperty("server.port"));
		Info.setPort( ctx.getEnvironment().getProperty("server.port"));
		for (int i = 0; i < 100; i++)
		  consumerControllerClient.getEmployee();
	}

	@Bean
	public ConsumerControllerClient consumerControllerClient() {
		return new ConsumerControllerClient();
	}
}