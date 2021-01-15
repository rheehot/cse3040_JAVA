package cse3040ex0803;


public class Ex08_03 {
	public static void swap(int a,int b) {
		int temp = a;
		a= b;
		b=temp;
	}
	
	public static void swap(int[] x) { 	
		int temp=x[0];
		x[0]=x[1];
		x[1]=temp;
	}
	public static void main(String[] args) {
		int x=10;
		int y=20;
		swap(x,y);
		System.out.println(x+" "+y);
		
		int[] a=new int[2];
		a[0]=10;
		a[1]=20;
		swap(a);
		System.out.println(a[0]+" "+a[1]);
	}
}