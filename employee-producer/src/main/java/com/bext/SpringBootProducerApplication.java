package com.bext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

import com.bext.model.Info;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
public class SpringBootProducerApplication {

	public static void main(String[] args){
		ApplicationContext ctx = SpringApplication.run( SpringBootProducerApplication.class, args);
		
		System.out.println( "server.port:" + ctx.getEnvironment().getProperty("server.port"));
		Info.setPort( ctx.getEnvironment().getProperty("server.port"));
	}
}