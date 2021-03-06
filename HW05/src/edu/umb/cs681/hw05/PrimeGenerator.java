package edu.umb.cs681.hw05;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.LinkedList;
import java.util.List;

public class PrimeGenerator {
    protected long from, to;
    protected LinkedList<Long> primes = new LinkedList<Long>();

    public PrimeGenerator(long from, long to){
        if(from >= 1 && to > from){
            this.from = from;
            this.to = to;
        }else{
            throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
        }
    }

    public LinkedList<Long> getPrimes(){ return primes; };

    protected boolean isPrime(long n){
        if(n <= 1)
            return false;

        if( n > 2 && n%2 == 0 )
            return false;

        long i = (long) Math.sqrt(n);

        while (i > 1) {
            if (n%i == 0) break;
            i--;
        }

        if (i == 1)
            return true;
        else
            return false;

    }

    public void generatePrimes(){
        for (long n = from; n <= to; n++) {
            if( isPrime(n) ){ primes.add(n); }
        }
    }

    public static void main(String[] args) {
        // Single-threaded prime number generation (with generatePrimes())
        PrimeGenerator gen = new PrimeGenerator(10, 200);
        gen.generatePrimes();
        System.out.println("\n" + gen.getPrimes().size() + " Prime Numbers found.");
        gen.getPrimes().forEach( (Long prime)-> System.out.print(prime + ", ") );
        System.out.println("\n");


        // Single-threaded prime number generation (without using generatePrimes())
        PrimeGenerator gen2 = new PrimeGenerator(10, 200);
        List<Long> primes = LongStream.rangeClosed(gen2.from, gen2.to)
                .filter( (long n)->gen2.isPrime(n) )
                .boxed()
                .collect(Collectors.toList());
        System.out.println("\n" + primes.size() + " Prime Numbers found.");
        primes.forEach( (Long prime)-> System.out.print(prime + ", ") );
        System.out.println("\n");


        // Single-threaded prime number generation (without using generatePrimes())
        PrimeGenerator gen3 = new PrimeGenerator(10, 200);
        long size = LongStream.rangeClosed(gen3.from, gen3.to)
                .filter( (long n)->gen3.isPrime(n) )
                .reduce( 0L, (long count, long n)->{System.out.print(n + ", ");
                    return ++count;} );
        System.out.println("\n" + size + " Prime Numbers found.");

    }
}