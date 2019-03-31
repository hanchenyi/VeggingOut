package com.example.demo;

import com.example.demo.tutorial.SortImpl;
import com.example.demo.tutorial.model.Singleton;
import com.example.demo.tutorial.model.TreeNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println(Singleton.INSTANCE.getValue());
		Singleton.INSTANCE.setValue(1);
		System.out.println(Singleton.INSTANCE.getValue());
	}

}



