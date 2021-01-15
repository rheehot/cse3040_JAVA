package cse3040hw1;

import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("ASCII code teller. Enter a letter: ");
		String val = in.nextLine();
		int num = val.charAt(0);

		if (((num >= 65 && num <= 90) || (num >= 97 && num <= 122)) && (val.length()) < 2) {
			System.out.printf("The ASCII code of C is %d\n", num);
		} else {
			System.out.println("You must input a single uppercase or lowercase alphabet.");
		}

	}
}
