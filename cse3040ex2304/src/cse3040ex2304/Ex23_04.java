package cse3040ex2304;

class ThreadEx5_1 extends Thread{
	public void run() {
		for(int i = 0 ; i<300;++i) {
			System.out.printf("%s", new String("|"));
		}
		System.out.print("elapsed time 2: " + (System.currentTimeMillis() - Ex23_04.startTime));
	}
}
public class Ex23_04 {
	static long startTime = 0;
	public static void main(String[] args) {
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();
		startTime = System.currentTimeMillis();
		for(int i = 0 ;i<300;++i) {
			System.out.printf("%s", new String("-"));
		}
		System.out.print("elapsed time 1: " + (System.currentTimeMillis() - Ex23_04.startTime));
	}
}
