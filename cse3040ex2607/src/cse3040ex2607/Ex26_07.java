package cse3040ex2607;

class Account {
	private int balance = 1000;

	public int getBalance() {
		return balance;
	}

	public synchronized void withdraw(int money) {
		if (balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			balance -= money;
		}
	}
}

class RunnableEx21 implements Runnable {
	Account acc = new Account();

	public void run() {
		while (acc.getBalance() >= 200) {
			int money = 200;
			acc.withdraw(money);
			System.out.println("balance: " + acc.getBalance());
		}
	}
}

public class Ex26_07 {
	public static void main(String[] args) {
		Runnable r = new RunnableEx21();
		new Thread(r).start();
		new Thread(r).start();
	}
}