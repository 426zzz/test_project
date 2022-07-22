package org.lyz.test_project.test;

import java.math.BigDecimal;

public class BigDecimalTest {

	// add
	public static BigDecimal add(BigDecimal b1, BigDecimal b2){
		return b1.add(b2);
	}

	// subtract
	public static BigDecimal subtract(BigDecimal b1, BigDecimal b2){
		return b1.subtract(b2);
	}

	// multiplication
	public static BigDecimal multiplication(BigDecimal b1, BigDecimal b2){
		return b1.multiply(b2);
	}

	// divide
	public static BigDecimal divide(BigDecimal b1, BigDecimal b2){
		return b1.divide(b2);
	}

	public static void main(String[] args) {
		// 数字
		BigDecimal b1 = new BigDecimal(10);
		BigDecimal b2 = new BigDecimal(2.2);
		BigDecimal b3 = new BigDecimal(5);
		// String
		BigDecimal b4 = new BigDecimal("10");
		BigDecimal b5 = new BigDecimal("2.2");
		BigDecimal b6 = new BigDecimal("5");

		System.out.println(add(b1, b2));
		System.out.println(subtract(b1, b2));
		System.out.println(multiplication(b1, b2));
		System.out.println(divide(b1, b3));

		System.out.println(add(b4, b5));
		System.out.println(subtract(b4, b5));
		System.out.println(multiplication(b4, b5));
		System.out.println(divide(b4, b6));


	}
}
