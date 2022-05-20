package edu.umb.cs681.hw13;

import java.util.concurrent.atomic.AtomicBoolean;

public class WithdrawRunnable implements Runnable {

	private ThreadSafeBankAccount threadSafeBankAccount = null;
	public AtomicBoolean done = new AtomicBoolean(false);
	
	@Override
	public void run() {
		while (true) {
			if (done.get()) {
				System.out.println(Thread.currentThread().getName() + "\t Amount of Money Withdraw");
				break;
			}
			System.out.println(Thread.currentThread().getName() + "\t Amount of Money getting Withdrawal");
			threadSafeBankAccount.withdraw(300);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.toString());
				continue;
			}
		}
	}

	public WithdrawRunnable(ThreadSafeBankAccount account) {
		this.threadSafeBankAccount = account;
	}

	public void setDone() {
		done.getAndSet(true);
	}


}