package edu.umb.cs681.hw13;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;


public class ThreadSafeBankAccount {

	private double balance = 0;
	private ReentrantLock lock = new ReentrantLock();

	private Condition sufficientFundsCondition = lock.newCondition();
	private Condition belowUpperLimitFundsCondition = lock.newCondition();

	public ThreadSafeBankAccount() {
		super();
	}

	public void withdraw(double amount) {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "\t Current Balance is : " + balance);
			while (balance <= 0) {
				try {
					System.out.println(Thread.currentThread().getName() + "\t Balance Not Sufficient to withdraw");
					sufficientFundsCondition.await();
				} catch (InterruptedException e) {
					return;
				}
			}

			balance -= amount;
			System.out.println(Thread.currentThread().getName() + "\t Updated Balance After withdrawal	:" + balance);
			belowUpperLimitFundsCondition.signalAll();

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void deposit(double amount) {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "\t Current Balance is : " + balance);
			while (balance >= 900) {
				try {
					System.out.println(Thread.currentThread().getName() + "\t Deposit Limit Exceeded");
					belowUpperLimitFundsCondition.await();
				} catch (InterruptedException e) {
					return;
				}
			}

			balance += amount;
			System.out.println(Thread.currentThread().getName() + "\t Updated Balance after depositing money: " + balance);
			sufficientFundsCondition.signalAll();

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}