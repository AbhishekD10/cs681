package edu.umb.cs681.hw13;

public class Main {

	public static void main(String[] args) {

		ThreadSafeBankAccount threadSafeBankAccount = new ThreadSafeBankAccount();
		WithdrawRunnable withdraw = new WithdrawRunnable(threadSafeBankAccount);
		DepositRunnable deposit = new DepositRunnable(threadSafeBankAccount);

		Thread td1 = new Thread(deposit);
		Thread tw1 = new Thread(withdraw);
		Thread td2 = new Thread(deposit);
		Thread tw2 = new Thread(withdraw);
		Thread td3 = new Thread(deposit);
		Thread tw3 = new Thread(withdraw);
		Thread td4 = new Thread(deposit);
		Thread tw4 = new Thread(withdraw);
		Thread td5 = new Thread(deposit);
		Thread tw5 = new Thread(withdraw);
		Thread td6 = new Thread(deposit);
		Thread tw6 = new Thread(withdraw);
		Thread td7 = new Thread(deposit);
		Thread tw7 = new Thread(withdraw);
		Thread td8 = new Thread(deposit);
		Thread tw8 = new Thread(withdraw);
		Thread td9 = new Thread(deposit);
		Thread tw9 = new Thread(withdraw);
		Thread td10 = new Thread(deposit);
		Thread tw10 = new Thread(withdraw);

		td1.start();
		tw1.start();
		td2.start();
		tw2.start();
		td3.start();
		tw3.start();
		td4.start();
		tw4.start();
		td5.start();
		tw5.start();
		td6.start();
		tw6.start();
		td7.start();
		tw7.start();
		td8.start();
		tw8.start();
		td9.start();
		tw9.start();
		td10.start();
		tw10.start();

		deposit.setDone();
		withdraw.setDone();

		td1.interrupt();
		tw1.interrupt();
		td2.interrupt();
		tw2.interrupt();
		td3.interrupt();
		tw3.interrupt();
		td4.interrupt();
		tw4.interrupt();
		td5.interrupt();
		tw5.interrupt();
		td6.interrupt();
		tw6.interrupt();
		td7.interrupt();
		tw7.interrupt();
		td8.interrupt();
		tw8.interrupt();
		td9.interrupt();
		tw9.interrupt();
		td10.interrupt();
		tw10.interrupt();

		try {
			td1.join();
			tw1.join();
			td2.join();
			tw2.join();
			td3.join();
			tw3.join();
			td4.join();
			tw4.join();
			td5.join();
			tw5.join();
			td6.join();
			tw6.join();
			td7.join();
			tw7.join();
			td8.join();
			tw8.join();
			td9.join();
			tw9.join();
			td10.join();
			tw10.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}