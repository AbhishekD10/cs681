package edu.umb.cs681.hw13;

import java.util.concurrent.atomic.AtomicBoolean;

public class DepositRunnable implements Runnable {

	private ThreadSafeBankAccount threadSafeBankAccount = null;
	private AtomicBoolean done = new AtomicBoolean(false);
	
	@Override
	public void run() {
		while (true) {
			if (done.get()) {
				System.out.println(Thread.currentThread().getName() + "\t Total Money Deposited");
				break;
			}
			System.out.println(Thread.currentThread().getName() + "\t Total amount of money getting deposited");
			threadSafeBankAccount.deposit(900);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.toString());
				continue;
			}
		}
	}

	public DepositRunnable(ThreadSafeBankAccount bankAccount) {
		this.threadSafeBankAccount = bankAccount;
	}

	public void setDone() {
		done.getAndSet(true);
	}

}