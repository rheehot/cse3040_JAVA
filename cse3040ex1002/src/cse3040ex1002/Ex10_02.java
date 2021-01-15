package cse3040ex1002;

interface CustomInterface{
	void method1();
	int b = 5;
	default void method2() {
		method4();
		method5();
		System.out.println("default method");
	}
	static void method3() {
		method5();
		System.out.println("static method");
	}
	private void method4() {
		System.out.println("private method");
	}
	public static void method5() {
		System.out.println("private static method");
	}
}

public class Ex10_02 implements CustomInterface{
	private int a=10;
	static private int c=5;
	public void method1() {System.out.println("abstract method");}
	public static void main(String[] args) {
		CustomInterface instance = new Ex10_02();
		instance.method1();
		instance.method2();
		CustomInterface.method3();
	}
}
