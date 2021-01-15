package cse3040cs06;

public class Ex06_05 {
	public static void main(String[] args) {
		int a[] = {1,3,5,7,9};
		int b[] = new int[a.length];
		int i;
		
		b = a;
		
		
		b[0] =111;b[1] = 222;b[2]=333;b[3]=444;b[4]=555;
		
		for(i=0;i<b.length;++i) {
			System.out.println(a[i]+" "+b[i]);
		}
	}
}
