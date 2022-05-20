package edu.umb.cs681.hw16;

import java.util.ArrayList;
import java.util.List;


public class Car {

    private String make, model;
    private int mileage, year;
    private int price;
    private int dominationCount;

    public Car(String make, String model, int year, int mileage, int price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
   
    public int getMileage() {
        return mileage;
    }
    public int getPrice() {
        return price;
    }

    public int getDominationCount() {
        return dominationCount;
    }
    
    public void setDominationCount(ArrayList<Car> cars) {
        for (Car car : cars) {
            if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
                    && (car.getYear() <= this.getYear())) {
                this.dominationCount++;
            }
        }
        this.dominationCount--;
    }

    @Override
    public boolean equals(Object obj) {
        Car car = (Car) obj;
        if(make.equals(car.getMake()) && model.equals(car.getModel()) && year==car.getYear() && mileage==car.getMileage() && price==car.getPrice() && dominationCount==car.getDominationCount())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return this.make+" "+this.model+" "+this.year+" "+this.mileage+" "+this.price;
    }

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Volvo", "V1", 2020, 25, 125000));
        cars.add(new Car("Bugati", "B2", 2017, 30, 250000));
        cars.add(new Car("Rolls-Royce", "Ghost", 2012,18 , 80000));
        cars.add(new Car("Lambergoni", "L1", 2019, 22, 95000));
        
        int mileage = cars.stream().parallel().map((Car car) -> car.getMileage())
                .reduce(0, (result, mileageCount) -> result > mileageCount ? result: mileageCount);

        System.out.println("Maximum mileage in the car lists is " + mileage + " mpg");
        
        int year = cars.stream().parallel().map((Car car) -> car.getYear())
                .reduce(0, (result, year_count) ->  result > year_count ? result : year_count);

        System.out.println("Latest car among the list was launched in " + year);
        
        int min_price = cars.stream().parallel().map((Car car) -> car.getPrice())
                .reduce((int) 100000, (result, price) ->  price > result ? result : price);

        System.out.println("Cheapeast car in the car list has price= $" + min_price);
    }
}