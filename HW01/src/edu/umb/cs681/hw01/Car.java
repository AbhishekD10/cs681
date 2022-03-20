package edu.umb.cs681.hw01;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.stream.Collectors;


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

		List<Car> sortByPrice = cars.stream().sorted(Comparator.comparing(Car::getPrice)).collect(Collectors.toList());

		List<Car> sortByYear = cars.stream().sorted(Comparator.comparing(Car::getYear)).collect(Collectors.toList());

		List<Car> sortByMileage = cars.stream().sorted(Comparator.comparing(Car::getMileage))
				.collect(Collectors.toList());

		List<Car> sortByDominationCount = cars.stream().sorted(Comparator.comparing(Car::getDominationCount))
				.collect(Collectors.toList());
         
		System.out.println("Sort by Price");
		sortByPrice.forEach((Car car) -> System.out.println(car.getMake()+" "+car.getPrice()));

		System.out.println("Sort by Year");
		sortByYear.forEach((Car car) -> System.out.println(car.getMake()+" "+car.getYear()));

		System.out.println("Sorted by Mileage");
		sortByMileage.forEach((Car car) -> System.out.println(car.getMake()+" "+car.getMileage()));

		System.out.println("Sorted by Domination Count");
		sortByDominationCount.forEach((Car car) -> System.out.println(car.getMake()+" "+car.getDominationCount()));
        
    }
}
