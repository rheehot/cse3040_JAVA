package cse3040ex1301;

public class Ex13_01 {
	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		for(int i = 0 ;i<10;++i) {
			try {
				result=number/(int)(Math.random()*10);
				System.out.println(result);
			}catch(Exception e) {
				System.out.println("division by zero");
			}
			
		}
	}
}
