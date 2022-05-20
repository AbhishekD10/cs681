package edu.umb.cs681.hw11;

import java.util.concurrent.locks.ReentrantLock;
import java.nio.file.Path;
import java.util.*;

public class AccessCounter {

	public Map<Path, Integer> ac = new HashMap<>();
	public ReentrantLock lock = new ReentrantLock();
	public static ReentrantLock staticlock = new ReentrantLock();
	private static AccessCounter instance = null;
	
	private AccessCounter() {
	};
	
	public void increment(Path file) {
		lock.lock();
		try {
			if (ac.get(file) != null)
                ac.put(file, ac.get(file) + 1);
            else
                ac.put(file, 1);
		} finally {
			lock.unlock();
		}
	}
	
	public int getCount(Path file) {
		lock.lock();
		try {
            if (ac.get(file) != null)
                return ac.get(file);
            else
                return 0;
        } finally {
			lock.unlock();
		}
	}
	
	public static AccessCounter getInstance() {
		staticlock.lock();
		try {
			if (instance == null) {
				instance = new AccessCounter();
			}
			return instance;
		} finally {
			staticlock.unlock();
		}
	}

}