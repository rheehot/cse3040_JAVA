package cse3040hw1;

import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int ran = (int)(Math.random()*99+1); 
		int s = 1,e=100;
		
		while(true) {
			System.out.printf("Guess a number (%d-%d): ",s,e);
			int ans = in.nextInt();
			
			if(ans == ran) {
				System.out.printf("Correct! Number of guesses: %d",ran);
				break;
			}else if(ans<s || ans>e){
				System.out.println("Not in range!");
			}else if(ans<ran) {
				System.out.println("Too small!");
				s = ans+1;
			}else if(ans>ran) {
				System.out.println("Too large!");
				e = ans-1;
			}
		}
	}
}
