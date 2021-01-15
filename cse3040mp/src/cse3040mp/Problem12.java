package cse3040mp;

class SubsequenceChecker{
	private static int pos[];
	public static void checker(int s,int c,int pos[],String str1, String str2) {
		int ans = str1.indexOf(str2.charAt(c),s+1);
		pos[c]=ans;
		if(ans==-1) {
			System.out.println(str2+ " is not a subsequence of "+str1);
			return;
		}
		else if(c==str2.length()-1) {
			System.out.println(str2+ " is a subsequence of "+str1);
			for(int i :pos) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		checker(ans,c+1,pos,str1,str2);
	}
	
	public static void check(String str1,String str2) {
		if(str2 == "" || str1=="") {
			System.out.println(str2+ " is not a subsequence of "+str1);
			return;
		}
		pos= new int[str2.length()];
		checker(-1,0,pos,str1,str2);
	}
}

public class Problem12 {
	public static void main(String[] args) {
		SubsequenceChecker.check("supercalifragilisticexpialidocious", "pads");
		SubsequenceChecker.check("supercalifragilisticexpialidocious", "padsx");
	}
}