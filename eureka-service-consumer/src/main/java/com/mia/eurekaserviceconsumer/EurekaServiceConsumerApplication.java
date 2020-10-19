package com.mia.eurekaserviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceConsumerApplication.class, args);
    }

}
