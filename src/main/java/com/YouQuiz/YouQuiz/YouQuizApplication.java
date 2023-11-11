package com.YouQuiz.YouQuiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.YouQuiz.YouQuiz.Mappers")
@EntityScan("com.YouQuiz.YouQuiz.entities")
public class YouQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(YouQuizApplication.class, args);
	}

}
