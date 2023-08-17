package com.example.patch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class PatchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatchServiceApplication.class, args);
	}

}
