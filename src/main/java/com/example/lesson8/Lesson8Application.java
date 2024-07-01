package com.example.lesson8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Lesson8Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson8Application.class, args);
	}

}
