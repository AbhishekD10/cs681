package edu.umb.cs681.hw18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentSingleton implements Runnable{
	
	private ConcurrentSingleton() {};
	private static AtomicReference<ConcurrentSingleton> instance = new AtomicReference<ConcurrentSingleton>();
	
	@Override
	public void run() {
		AtomicReference<ConcurrentSingleton> singletonInstance = ConcurrentSingleton.getInstance();
		System.out.println("Current Instance: " + singletonInstance);
	}
	
	public static AtomicReference<ConcurrentSingleton> getInstance() {
			if(instance.get() == null) {
				instance.set(new ConcurrentSingleton());
				System.out.println("ConcurrentSingleton instance");
			}
		return instance;
	}


	public static void main(String[] args) {
		Thread thread1 = new Thread(new ConcurrentSingleton());
		Thread thread2 = new Thread(new ConcurrentSingleton());
		Thread thread3 = new Thread(new ConcurrentSingleton());
		ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(thread1);
        executor.execute(thread2);
        executor.execute(thread3);

        executor.shutdown();

        try {
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}