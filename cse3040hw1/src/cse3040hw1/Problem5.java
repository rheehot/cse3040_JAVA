package cse3040hw1;

import java.util.Scanner;

public class Problem5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter exam scores of each student.");
		
		int[] f= {0,-1},s= {0,-1};
		
		for(int i = 1 ;i<=5;++i) {
			System.out.printf("Score of student %d: ",i);
			int tmp = in.nextInt();
			if(f[1]==-1) {
				f[0]=i;
				f[1]=tmp;
			}else if(f[1]<tmp){
				s[0] = f[0];
				f[0] = i;
				s[1]=f[1];
				f[1]=tmp;
			}
		}
		
		System.out.printf("The 1st place is student %d with %d points. \n",f[0],f[1]);
		System.out.printf("The 2nd place is student %d with %d points. \n",s[0],s[1]);
	}
}
