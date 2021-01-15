package cse3040ex2603;

import javax.swing.JOptionPane;

class ThreadEx14_1 extends Thread {
	public void run() {
		int i = 10;
		while (i != 0 && !isInterrupted()) {
			System.out.println(i--);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("countdown complete.");
	}
}

public class Ex26_03 {
	public static void main(String[] args) throws Exception {
		ThreadEx14_1 th1 = new ThreadEx14_1();
		th1.start();
		String input = JOptionPane.showInputDialog("Enter any string.");
		System.out.println("You entered " + input);
		th1.interrupt();
		System.out.println("isInterrupted(): " + th1.isInterrupted());
	}
}