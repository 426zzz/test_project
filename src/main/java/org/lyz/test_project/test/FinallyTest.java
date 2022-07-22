package org.lyz.test_project.test;

public class FinallyTest {
	
	public static String test() {
		try {
		    System.out.println("Inside try");
//		    throw new RuntimeException();
		    return "from try";
		} finally {
		    throw new RuntimeException();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println(test());
	}
}
