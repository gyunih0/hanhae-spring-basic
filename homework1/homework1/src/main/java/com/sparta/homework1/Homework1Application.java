package com.sparta.homework1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Homework1Application {

	public static void main(String[] args) {
		SpringApplication.run(Homework1Application.class, args);
	}
}
