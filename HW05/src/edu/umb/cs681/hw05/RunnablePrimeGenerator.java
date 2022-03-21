package edu.umb.cs681.hw05;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {

    public RunnablePrimeGenerator(long from, long to) {
        super(from, to);
    }

    public void run() {
        generatePrimes();
    }

    public static void main(String[] args) {
        RunnablePrimeGenerator gen1 = new RunnablePrimeGenerator(1, 200);
        RunnablePrimeGenerator gen2 = new RunnablePrimeGenerator(201, 400);
        Thread t1 = new Thread(gen1);
        Thread t2 = new Thread(gen2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}

        gen1.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen2.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );

        long primeNum = gen1.getPrimes().size() + gen2.getPrimes().size();
        System.out.println("\nTotally " + primeNum + " Prime Numbers found.");


    }

}