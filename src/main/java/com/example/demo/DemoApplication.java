package com.example.demo;

import com.example.demo.util.thread.SortImpl;
import com.example.demo.util.thread.TestEnum;
import com.example.demo.util.thread.TreeNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.remove();
		while (!stack.isEmpty()) {
			SortImpl impl = new SortImpl();
			int[] a = {1, 2, 3, 4, 5, 9, 7};
			List<Integer> aa = Arrays.stream(a).boxed().collect(Collectors.toList());
			impl.quickSort(a, 0, a.length - 1);
			System.out.println(Arrays.toString(a));
			SpringApplication.run(DemoApplication.class, args);
		}
	}

}



