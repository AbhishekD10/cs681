package edu.umb.cs681.hw07;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSingleton{
    private ConcurrentSingleton() {
    };

    private static ConcurrentSingleton instance = null;
    private static ReentrantLock lock = new ReentrantLock();


    public static ConcurrentSingleton getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new ConcurrentSingleton();
            }
            return instance;
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args)  {

        for (int i = 0; i < 15; i++) {
            Thread t = new Thread(() -> {
                System.out.println(ConcurrentSingleton.getInstance());
            });
            t.start();
        }
    }

}