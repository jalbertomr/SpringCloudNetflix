package com.bext.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bext.model.Info;

@Controller
public class ConsumerControllerClient {

	@Autowired
	//private DiscoveryClient discoveryClient;
	private LoadBalancerClient loadBalancer;
	
	public void getEmployee() throws RestClientException, IOException {
		//String baseUrl="http://localhost:8080/empleado";
		//List<ServiceInstance> instances = discoveryClient.getInstances("empleado-productor");
		ServiceInstance serviceInstance = loadBalancer.choose("empleado-productor");
		System.out.println( "serviceInstance.getUri():" + serviceInstance.getUri());
		Info.setServiceInstance_Uri( serviceInstance.getUri().toString() );
		
		String baseUrl = serviceInstance.getUri().toString();
		baseUrl = baseUrl + "/empleado";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange( baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println( ex);
		}
		System.out.println( response.getBody());
	}
	
	private static HttpEntity<?> getHeaders() throws IOException{
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
