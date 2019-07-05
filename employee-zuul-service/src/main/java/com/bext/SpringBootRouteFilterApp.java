package com.bext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.bext.filter.ErrorFilter;
import com.bext.filter.PostFilter;
import com.bext.filter.PreFilter;
import com.bext.filter.RouteFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class SpringBootRouteFilterApp {
	
	public static void main(String... args ) {
	   SpringApplication.run(SpringBootRouteFilterApp.class, args);
	}
	
	@Bean
    public PreFilter preFilter() {
    	return new PreFilter();
    }
    
    @Bean
    public PostFilter postFilter() {
    	return new PostFilter();
    }
    
    @Bean
    public ErrorFilter errorFilter() {
    	return new ErrorFilter();
    }
    
    @Bean
    public RouteFilter routeFilter() {
    	return new RouteFilter();
    }
}
