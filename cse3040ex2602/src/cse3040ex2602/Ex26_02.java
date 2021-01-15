package cse3040ex2602;

import javax.swing.JOptionPane;

class ThreadEx13_1 extends Thread {
	public void run() {
		int i = 10;
		while (i != 0 && !isInterrupted()) {
			System.out.println(i--);
			for (long x = 0; x < 2500000000L; x++)
				; // waste time
		}
	}
}

public class Ex26_02 {
	public static void main(String[] args) {
		ThreadEx13_1 th1 = new ThreadEx13_1();
		th1.start();
		String input = JOptionPane.showInputDialog("Enter any string.");
		System.out.println("You entered " + input);
		th1.interrupt();
		System.out.println("isInterrupted(): " + th1.isInterrupted());
	}
}