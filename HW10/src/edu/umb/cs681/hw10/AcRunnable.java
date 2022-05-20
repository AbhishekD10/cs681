package edu.umb.cs681.hw10;

public class AcRunnable extends Aircraft implements Runnable {

    public AcRunnable(Position pos) {
        super(pos);
    }

    public void run() {
        Position pos = new Position(97.56, 96.65, 67.35);
        System.out.println("Original Position : " + this.getPosition().toString());
        this.setPosition(pos);
        System.out.println("Changed Position : " + this.getPosition().toString());
    }

    public static void main(String[] args) throws InterruptedException {
    
        Position position1 = new Position(56.67, 63.89, 45.78);
        Position position2 = new Position(82.87, 61.23, 33.78);
        Position position3 = new Position(52.56, 67.89, 23.56);

        Thread thread1 = new Thread(new AcRunnable(position1));
        Thread thread2 = new Thread(new AcRunnable(position2));
        Thread thread3 = new Thread(new AcRunnable(position3));
        thread1.start();
        thread2.start();
        thread3.start();
        try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    }

}