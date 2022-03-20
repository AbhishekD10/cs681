package edu.umb.cs681.hw07;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSingleton {
	
	private static ConcurrentSingleton instance = null;
	private static ReentrantLock lock = new ReentrantLock();
	
	private ConcurrentSingleton() {
	}

	public static ConcurrentSingleton getInstance() {
		
		try {
			lock.lock();
			if (instance == null)
				instance = new ConcurrentSingleton();
			return instance;
		} finally {
			lock.unlock();
		}
	}

}