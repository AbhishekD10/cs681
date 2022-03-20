package edu.umb.cs681.hw02;

import java.util.List;
import java.util.ArrayList;

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
    public int getPrice() {
        return price;
    }
    public int getMileage() {
        return mileage;
    }

    public void setDominationCount(List<Car> cars) {
        for (Car car : cars) {
            if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
                    && (car.getYear() <= this.getYear())) {
                this.dominationCount++;
            }
        }
        this.dominationCount--;
    }
    
    public int getDominationCount() {
        return dominationCount;
    }

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Volvo", "V1", 2020, 25, 125000));
        cars.add(new Car("Bugati", "B2", 2019, 30, 250000));
        cars.add(new Car("Rolls-Royce", "Ghost", 2012,18 , 80000));
        cars.add(new Car("Lambergoni", "L1", 2019, 22, 95000));
        
        cars.forEach((Car car) -> car.setDominationCount(cars));
		
		Integer minPrice = cars.stream().map((Car car) -> car.getPrice()).min(Integer::compare).get();
        System.out.println("Lowest priced car: $"+minPrice);

        Integer maxPrice = cars.stream().map((Car car) -> car.getPrice()).max(Integer::compare).get();
        System.out.println("Highest priced car: $"+maxPrice);
        
        Integer averagePrice = cars.stream().map((Car car) -> car.getPrice()).reduce(0, (result,price) -> result+price, (endResult, endResult1) -> endResult)/cars.size();
        
        System.out.println("Average price of all Cars in the List: $" + averagePrice);
    }
}
