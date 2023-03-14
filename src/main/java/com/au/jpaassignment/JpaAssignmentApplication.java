package com.au.jpaassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaAssignmentApplication {
	// Hakuna Matata
	public static void main(String[] args) {
		try {
			SpringApplication.run(JpaAssignmentApplication.class, args);
		} catch (Throwable throwable){
			System.out.println(throwable.toString());
			throwable.printStackTrace();
		}
	}

}
