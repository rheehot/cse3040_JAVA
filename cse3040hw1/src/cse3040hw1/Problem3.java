package cse3040hw1;

import java.util.Scanner;

public class Problem3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a text: ");
		String s = in.nextLine();
		
		while(true) {
			System.out.print("Enter a letter: ");
			String ans = in.nextLine();
			int count = 0;
			
			if(ans.length()!= 1)
				System.out.println("You must enter a single letter. ");
			else {
				for(int i = 0 ; i<s.length();++i) {
					if(s.charAt(i) == ans.charAt(0)) count++;
				}
				System.out.printf("There are %d %c's in the text.\n",count,ans.charAt(0));
				break;
			}
		}
	}
}
