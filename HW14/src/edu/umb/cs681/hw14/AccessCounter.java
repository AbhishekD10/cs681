package edu.umb.cs681.hw14;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;


public class AccessCounter {

    private ConcurrentHashMap<Path, AtomicInteger> concurrentHashMap = new ConcurrentHashMap<Path, AtomicInteger>();
    private static ReentrantLock staticLock = new ReentrantLock();
    private static AccessCounter instance = null;

    private AccessCounter() {
    }

    public static AccessCounter getInstance() {
        staticLock.lock();
        try {
            if (instance == null)
                instance = new AccessCounter();
            return instance;
        } finally {
            staticLock.unlock();
        }
    }

    public void increment(Path path) {
    	concurrentHashMap.putIfAbsent(path, new AtomicInteger(1));
    }

    public int getCount(Path path) {
        return concurrentHashMap.get(path).incrementAndGet();
    }
}