package org.lyz.test_project.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		Random random = new Random();
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			int nextInt = random.nextInt(100);
			arr.add(nextInt);
		}
		
		arr.forEach(s -> {
			int num = 0;
			for (int i = 0; i < arr.size(); i++) {
				if(arr.get(i) == s)
				num ++;
			}
			System.out.println(s + ": 次数" + num);
		});
	}
}
