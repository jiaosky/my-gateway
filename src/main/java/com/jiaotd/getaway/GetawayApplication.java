package com.jiaotd.getaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication(scanBasePackages = "com.jiaotd")
public class GetawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetawayApplication.class, args);
    }

}
