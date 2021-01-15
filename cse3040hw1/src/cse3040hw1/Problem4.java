package cse3040hw1;

import java.util.Scanner;

public class Problem4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a text: ");
		String s = in.nextLine();
		
		while(true) {
			System.out.print("Enter a letter: ");
			String ans = in.nextLine();
			int count = 0;
			
			if(ans.length()== 0)
				System.out.println("You must enter a single letter. ");
			else {
				int pos=-1;
				while((pos=s.indexOf(ans,pos+1))!=-1) {
					count++;
				}
				System.out.printf("There are %d instance of \"%s\" \n",count,ans);
				break;
			}
		}
	}
}
