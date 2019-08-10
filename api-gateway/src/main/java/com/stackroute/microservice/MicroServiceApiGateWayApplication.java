package com.stackroute.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MicroServiceApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApiGateWayApplication.class, args);
	}

}
