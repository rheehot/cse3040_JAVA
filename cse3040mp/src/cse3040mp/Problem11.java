package cse3040mp;

class PalindromeChecker{
	private static int d[][];
	
	public static int checker(int a,int b,String str) {
		if(a==b) return 1;
		else if(a+1==b) {
			if(str.charAt(a) == str.charAt(b)) return 1;
			else return 0;
		}
		
		if(d[a][b]!=-1) return d[a][b];
		if(str.charAt(a)!=str.charAt(b)) {return d[a][b]=0;}
		else {
			return d[a][b]=checker(a+1,b-1,str);
		}
	}
	public static void check(String str) {
		d= new int[str.length()][str.length()];
		// √ ±‚»≠
		for(int i=0;i<str.length();++i) {
			for(int j = 0 ;j<str.length();++j) {
				d[i][j]=-1;
			}
		}

		if(checker(0,str.length()-1,str)>0) {
			System.out.println(str+ " is a palindrome.");
		}else {
			System.out.println(str+ " is not a palindrome.");
		}
		
	}
	public static void check(long a) {
		check(Long.toString(a));
	}
}

public class Problem11 {
	public static void main(String[] args) {
		PalindromeChecker.check("abcde");
		PalindromeChecker.check("abcba");
		PalindromeChecker.check(1234);
		PalindromeChecker.check(12321);
	}
}
