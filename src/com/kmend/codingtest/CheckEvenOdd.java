package com.kmend.codingtest;

import java.util.Scanner;

public class CheckEvenOdd {

	public static void main(String[] args) {
	    System.out.println("Enter an Integer number:");

	    Scanner input = new Scanner(System.in);
	    Integer number = input.nextInt();

	    /*
	    System.out.println(Integer.toBinaryString(number));
	    System.out.println(Integer.toBinaryString(0));
	    System.out.println(Integer.toBinaryString(1));
	    */

	    checkEvenOdd(number);
	    checkEvenOddRestricted(number);
	    checkEvenOddRestricted2(number);
	}

	private static void checkEvenOdd(Integer number) {
		if (number % 2 == 0) {
	    	System.out.println("Number is EVEN");
	    } else {
	    	System.out.println("Number is ODD");
	    }
	}

	private static void checkEvenOddRestricted(Integer number) {
		if ((number & 1) == 0) {
			System.out.println("Number is EVEN");
		} else {
			System.out.println("Number is ODD");
		}		
	}

	private static void checkEvenOddRestricted2(Integer number) {
		Boolean isEven = true;
		if (number > 0) {
			for (int i = 1; i <= number; i++) {
				isEven = !isEven;
			}
		} else {
			for (int i = -1; i >= number; i--) {
				isEven = !isEven;
			}
		}

        System.out.println(isEven ? "Number is EVEN" : "Number is ODD");
	}
}
