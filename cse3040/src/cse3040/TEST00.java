package cse3040;

class A{
	public int b;
	public int getB(A a) {
		return a.b;
	}
}

class B extends A {
	public int b;
	@Override
	public int getB(A a) {
		return a.b;
	}
}

public class TEST00 {
	public static void main(String[] args) {
	}
}
	