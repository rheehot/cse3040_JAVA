package cse3040ex2601;

class ThreadEx12_1 extends Thread {
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		for (int i = 0; i < 300; i++) {
			System.out.print("-");
		}
		System.out.print("<<end of th1>>");
	}
}

class ThreadEx12_2 extends Thread {
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		for (int i = 0; i < 300; i++) {
			System.out.print("|");
		}
		System.out.print("<<end of th2>>");
	}
}

public class Ex26_01 {
	public static void main(String args[]) {
		ThreadEx12_1 th1 = new ThreadEx12_1();
		ThreadEx12_2 th2 = new ThreadEx12_2();
		th1.start();
		th2.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.print("<<end of main>>");
	}
}
