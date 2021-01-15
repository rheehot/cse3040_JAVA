package cse3040cs06;

public class Ex06_03 {
	public static void main(String[] args) {
		int a[] = {1,3,5,7,9};
		int b[] = new int[a.length];
		
		b=a;
		
		b[0] = 10;
		for(int i = 0 ; i<a.length;++i) {
			System.out.println(a[i]+" "+b[i]);
		}
	}
}
