package com.company.mainBank;

import com.company.Main;
import com.company.interfaces.Driveable;
import com.company.people.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Car implements Driveable {
    private static int uniqueNumber;
    private final int currentNumber;
    private String color;
    private int year;
    private Driver driver;
    private final Logger logger = LogManager.getLogger(Car.class);

    {
        Car.uniqueNumber++;
        this.currentNumber = Car.uniqueNumber;
    }


    public Car() {

    }

    public Car(String color, int year) {
        this.color = color;
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getCurrentNumber() {
        return this.currentNumber;
    }


    public void sound() {
        logger.info("beep-beep");
    }

    public void style() {
        logger.info("SimpleCar-style");
    }

    @Override
    public void drive(Driver driver) {
        logger.info("I am driver and I can drive simple car! My name is " + driver.getName());
    }

    @Override
    public void needToChange() {
        if(this.year > 1950) {
            logger.info("You need to change this car!!!");
        }
    }

    @Override
    public int hashCode() {
        int result = getYear();
        result = 31 * result + getDriver().hashCode() + getCurrentNumber();
        result = 31 * result + getColor().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Car)) return false;

        Car car = (Car) obj;

        if (getDriver() != null && getDriver().equals(car.getDriver()) &&
                getYear() == car.getYear() && getColor() != null &&
                getColor().equals(car.getColor()) && getCurrentNumber() == car.getCurrentNumber()) {

            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Car{number=" + getCurrentNumber() + ", color=\'" + getColor() +
                ", driver=" + getDriver() + ", year=" + getYear() + '}';
    }
}
