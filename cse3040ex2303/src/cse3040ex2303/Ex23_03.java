package cse3040ex2303;

public class Ex23_03 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		for(int i = 0 ; i<300;++i) {
			System.out.printf("%s", new String("-"));
		}
		
		System.out.println("elapsed time: "+(System.currentTimeMillis()-startTime));
		
		for(int i = 0 ; i<300;++i) {
			System.out.printf("%s", new String("|"));
		}
		
		System.out.println("elapsed time: "+(System.currentTimeMillis()-startTime));
	}
}
