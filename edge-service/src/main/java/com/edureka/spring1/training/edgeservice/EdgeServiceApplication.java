package com.edureka.spring1.training.edgeservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
// this is the gateway
// all the calls to product/order service are directed to this gateway service
// this is done using zuul
@Slf4j
public class EdgeServiceApplication {

	public static void main(String[] args) {
		log.info("Check to see where all this starts");
		SpringApplication.run(EdgeServiceApplication.class, args);
	}

}
