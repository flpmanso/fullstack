package com.bento.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
		"com.bento.fullstack.entities"
})
@EnableJpaRepositories(basePackages = {
		"com.bento.fullstack.persistence",
		"com.bento.fullstack.service",
		"com.bento.fullstack.controller"
})
public class FullstackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullstackApplication.class, args);
	}

}
