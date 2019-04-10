package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		//int[] c = Arrays.asList(1,2,3,4,5).stream().mapToInt(Integer::intValue).toArray();
 		SpringApplication.run(DemoApplication.class, args);
	}


}



