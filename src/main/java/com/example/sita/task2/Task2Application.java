package com.example.sita.task2;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.example.sita.task2"})
public class Task2Application {

	public static void main(String[] args) {
		SpringApplication.run(Task2Application.class, args);
	}


}
