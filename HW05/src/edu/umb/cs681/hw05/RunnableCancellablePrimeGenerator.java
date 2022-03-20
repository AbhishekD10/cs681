package edu.umb.cs681.hw05;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeGenerator extends RunnablePrimeGenerator {
	private boolean done = false;
	private ReentrantLock lock = new ReentrantLock();

	public RunnableCancellablePrimeGenerator(long from, long to) {
		super(from, to);
	}

	public void setDone() {
		lock.lock();
		try {
			done = false;
		} finally {
			lock.unlock();
		}
	}

	public void generatePrimes() {
		for (long n = from; n <= to; n++) {
			lock.lock();
			
			try {
				if (done) {
					System.out.println("Stopped generating prime numbers");
					this.primes.clear();
					break;
				}
				if (isPrime(n)) {
					this.primes.add(n);
				}
			} finally {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		RunnableCancellablePrimeGenerator primeGenerator = new RunnableCancellablePrimeGenerator(1, 200);
		Thread thread = new Thread(primeGenerator);
		try {
			thread.start();
			primeGenerator.setDone();
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		primeGenerator.getPrimes().forEach((Long prime) -> System.out.print(prime + ", "));
		System.out.println("\n Total Number of Primes : " + primeGenerator.getPrimes().size());
	}
}