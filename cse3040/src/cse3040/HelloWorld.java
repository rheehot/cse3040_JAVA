package cse3040;

import java.util.Random;

//import java.util.Random;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello, World!");
		System.out.println("Hello, World!".length());
		
		// ctrl + shift + o : �˾Ƽ� ã����
		Random gen = new Random();
		System.out.println(gen.nextInt()%10);
		
		
	}
}