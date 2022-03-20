package edu.umb.cs681.hw04;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {

	public RunnablePrimeGenerator(long from, long to) {
		super(from, to);
	}

	public void run() {
		generatePrimes();
	}

	public static void main(String[] args) {
		
		//Running one thread
		System.out.println("Running with single thread");
		RunnablePrimeGenerator primeGenerator = new RunnablePrimeGenerator(1L, 2000000L);
		Thread thread = new Thread(primeGenerator);
		long start1 = System.currentTimeMillis();
		try {
			thread.start();
			thread.join();
		} catch (InterruptedException e) {
		}
		
		long end1 = System.currentTimeMillis();
		float diff1 = (end1 - start1);
		
		long primeNum1 = primeGenerator.getPrimes().size();
		System.out.println("Total number of primes = " + primeNum1);
		System.out.println("Time taken with 1 thread: " + diff1 + " seconds");

		//Running two threads
		System.out.println("Running with Two Threads");
		RunnablePrimeGenerator primeGenerator1 = new RunnablePrimeGenerator(1L, 1000000L);
		RunnablePrimeGenerator primeGenerator2 = new RunnablePrimeGenerator(1000000L, 2000000L);
		Thread thread1 = new Thread(primeGenerator1);
		Thread thread2 = new Thread(primeGenerator2);
		long start2 = System.currentTimeMillis();
		try {
			thread1.start();
			thread2.start();
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
		}
		
		long end2 = System.currentTimeMillis();
		float diff2 = (end2 - start2);
		
		long primeNum2 = primeGenerator1.getPrimes().size() + primeGenerator2.getPrimes().size();
		System.out.println("Total number of primes = " + primeNum2);
		System.out.println("Time taken with 2 thread: " + diff2 + " seconds");
		
		//Running four threads
		System.out.println("Running with four Threads");
		RunnablePrimeGenerator primeGenerator3 = new RunnablePrimeGenerator(1L, 500000L);
		RunnablePrimeGenerator primeGenerator4 = new RunnablePrimeGenerator(500000L, 1000000L);
		RunnablePrimeGenerator primeGenerator5 = new RunnablePrimeGenerator(1000000L, 1500000L);
		RunnablePrimeGenerator primeGenerator6 = new RunnablePrimeGenerator(1500000L, 2000000L);

		Thread thread3 = new Thread(primeGenerator3);
		Thread thread4 = new Thread(primeGenerator4);
		Thread thread5 = new Thread(primeGenerator5);
		Thread thread6 = new Thread(primeGenerator6);
		
		long start3 = System.currentTimeMillis();
		try {
			thread3.start();
			thread4.start();
			thread5.start();
			thread6.start();
			thread3.join();
			thread4.join();
			thread5.join();
			thread6.join();
		} catch (InterruptedException e) {
		}
		
		long end3 = System.currentTimeMillis();
		float diff3 = (end3 - start3);
		System.out.println("Time taken with 4 thread: " + diff3 + " seconds");
		
		long primeNum3 = primeGenerator3.getPrimes().size() + primeGenerator4.getPrimes().size() + primeGenerator5.getPrimes().size() + primeGenerator6.getPrimes().size();

		System.out.println("Total number of primes = " + primeNum3);
		
		//Running eight threads
		System.out.println("Running with eight threads");
		RunnablePrimeGenerator primeGenerator7 = new RunnablePrimeGenerator(1L, 250000L);
		RunnablePrimeGenerator primeGenerator8 = new RunnablePrimeGenerator(250000L, 500000L);
		RunnablePrimeGenerator primeGenerator9 = new RunnablePrimeGenerator(500000L, 750000L);
		RunnablePrimeGenerator primeGenerator10 = new RunnablePrimeGenerator(750000L, 1000000L);
		RunnablePrimeGenerator primeGenerator11 = new RunnablePrimeGenerator(1000000L, 1250000L);
		RunnablePrimeGenerator primeGenerator12 = new RunnablePrimeGenerator(1250000L, 1500000L);
		RunnablePrimeGenerator primeGenerator13 = new RunnablePrimeGenerator(1500000L, 1750000L);
		RunnablePrimeGenerator primeGenerator14 = new RunnablePrimeGenerator(1750000L, 2000000L);

		Thread thread7 = new Thread(primeGenerator7);
		Thread thread8 = new Thread(primeGenerator8);
		Thread thread9 = new Thread(primeGenerator9);
		Thread thread10 = new Thread(primeGenerator10);
		Thread thread11 = new Thread(primeGenerator11);
		Thread thread12 = new Thread(primeGenerator12);
		Thread thread13 = new Thread(primeGenerator13);
		Thread thread14 = new Thread(primeGenerator14);

		long start4 = System.currentTimeMillis();
		
		try {
			thread7.start();
			thread8.start();
			thread9.start();
			thread10.start();
			thread11.start();
			thread12.start();
			thread13.start();
			thread14.start();
			thread7.join();
			thread8.join();
			thread9.join();
			thread10.join();
			thread11.join();
			thread12.join();
			thread13.join();
			thread14.join();
		} catch (InterruptedException e) {
		}

		long end4 = System.currentTimeMillis();
		float time4 = (end4 - start4);

		long primeNum4 = primeGenerator7.getPrimes().size() + primeGenerator8.getPrimes().size() + primeGenerator9.getPrimes().size() + primeGenerator10.getPrimes().size()
				+ primeGenerator11.getPrimes().size() + primeGenerator12.getPrimes().size() + primeGenerator13.getPrimes().size() + primeGenerator14.getPrimes().size();
		System.out.println("Total number of primes : " +primeNum4);
		System.out.println("Time taken with 8 threads: " + time4 + " seconds");

		// With 16 threads
		System.out.println("Running with 16 threads :");
		RunnablePrimeGenerator primeGenerator15 = new RunnablePrimeGenerator(1L, 125000L);
		RunnablePrimeGenerator primeGenerator16 = new RunnablePrimeGenerator(125000L, 250000L);
		RunnablePrimeGenerator primeGenerator17 = new RunnablePrimeGenerator(250000L, 375000L);
		RunnablePrimeGenerator primeGenerator18 = new RunnablePrimeGenerator(375000L, 500000L);
		RunnablePrimeGenerator primeGenerator19 = new RunnablePrimeGenerator(500000L, 625000L);
		RunnablePrimeGenerator primeGenerator20 = new RunnablePrimeGenerator(625000L, 750000L);
		RunnablePrimeGenerator primeGenerator21 = new RunnablePrimeGenerator(750000L, 875000L);
		RunnablePrimeGenerator primeGenerator22 = new RunnablePrimeGenerator(875000L, 1000000L);
		RunnablePrimeGenerator primeGenerator23 = new RunnablePrimeGenerator(1000000L, 1125000L);
		RunnablePrimeGenerator primeGenerator24 = new RunnablePrimeGenerator(1125000L, 1250000L);
		RunnablePrimeGenerator primeGenerator25 = new RunnablePrimeGenerator(1250000L, 1375000L);
		RunnablePrimeGenerator primeGenerator26 = new RunnablePrimeGenerator(1375000L, 1500000L);
		RunnablePrimeGenerator primeGenerator27 = new RunnablePrimeGenerator(1500000L, 1625000L);
		RunnablePrimeGenerator primeGenerator28 = new RunnablePrimeGenerator(1625000L, 1750000L);
		RunnablePrimeGenerator primeGenerator29 = new RunnablePrimeGenerator(1750000L, 1875000L);
		RunnablePrimeGenerator primeGenerator30 = new RunnablePrimeGenerator(1875000L, 2000000L);

		Thread thread15 = new Thread(primeGenerator15);
		Thread thread16 = new Thread(primeGenerator16);
		Thread thread17 = new Thread(primeGenerator17);
		Thread thread18 = new Thread(primeGenerator18);
		Thread thread19 = new Thread(primeGenerator19);
		Thread thread20 = new Thread(primeGenerator20);
		Thread thread21 = new Thread(primeGenerator21);
		Thread thread22 = new Thread(primeGenerator22);
		Thread thread23 = new Thread(primeGenerator23);
		Thread thread24 = new Thread(primeGenerator24);
		Thread thread25 = new Thread(primeGenerator25);
		Thread thread26 = new Thread(primeGenerator26);
		Thread thread27 = new Thread(primeGenerator27);
		Thread thread28 = new Thread(primeGenerator28);
		Thread thread29 = new Thread(primeGenerator29);
		Thread thread30 = new Thread(primeGenerator30);

		long start5 = System.currentTimeMillis();
		
		try {
			thread15.start();
			thread16.start();
			thread17.start();
			thread18.start();
			thread19.start();
			thread20.start();
			thread21.start();
			thread22.start();
			thread23.start();
			thread24.start();
			thread25.start();
			thread26.start();
			thread27.start();
			thread28.start();
			thread29.start();
			thread30.start();
			thread15.join();
			thread16.join();
			thread17.join();
			thread18.join();
			thread19.join();
			thread20.join();
			thread21.join();
			thread22.join();
			thread23.join();
			thread24.join();
			thread25.join();
			thread26.join();
			thread27.join();
			thread28.join();
			thread29.join();
			thread30.join();
		} catch (InterruptedException e) {
		}

		long end5 = System.currentTimeMillis();
		float time5 = (end5 - start5);

		long primeNum5 = primeGenerator15.getPrimes().size() + primeGenerator16.getPrimes().size() + primeGenerator17.getPrimes().size()
				+ primeGenerator18.getPrimes().size() + primeGenerator19.getPrimes().size() + primeGenerator20.getPrimes().size() + primeGenerator21.getPrimes().size()
				+ primeGenerator22.getPrimes().size() + primeGenerator23.getPrimes().size() + primeGenerator24.getPrimes().size() + primeGenerator25.getPrimes().size()
				+ primeGenerator26.getPrimes().size() + primeGenerator27.getPrimes().size() + primeGenerator28.getPrimes().size() + primeGenerator29.getPrimes().size()
				+ primeGenerator30.getPrimes().size();
		System.out.println("Total number of primes : " +primeNum5);
		System.out.println("Time taken with 16 threads: " + time5 + " seconds");	
	}
}