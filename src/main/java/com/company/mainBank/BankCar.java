package com.company.mainBank;

import com.company.Main;
import com.company.interfaces.Driveable;
import com.company.people.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BankCar extends Car {
    private int uniqueNumber;
    private boolean isPassenger;
    private boolean isArmored;
    private Driver driver;
    private final Logger logger = LogManager.getLogger(BankCar.class);

    public BankCar() {

    }

    public BankCar(String color, String mark, int uniqueNumber, boolean isPassenger, boolean isArmored, Driver driver) {
        super(color, mark);
        this.uniqueNumber = uniqueNumber;
        this.isPassenger = isPassenger;
        this.isArmored = isArmored;
        this.driver = driver;
    }


    public int getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(int uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public boolean isPassenger() {
        return isPassenger;
    }

    public void setPassenger(boolean passenger) {
        isPassenger = passenger;
    }

    public boolean isArmored() {
        return isArmored;
    }

    public void setArmored(boolean armored) {
        isArmored = armored;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public int hashCode() {
        int result = super.getColor().hashCode();
        result = 31 * result + super.getMark().hashCode();
        result = 31 * result + getUniqueNumber();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof BankCar)) return false;

        BankCar car = (BankCar) obj;

        if (getColor() != null && getColor().equals(car.getColor()) &&
                getMark() != null && getMark().equals(car.getMark()) &&
                getUniqueNumber() == car.getUniqueNumber() && isArmored() == car.isArmored() &&
                isPassenger() == car.isPassenger()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "BankCar - Color: " + getColor() + ", Mark: " + getMark() + ", Number: " + getUniqueNumber() +
                ", isPass: " + isPassenger() + ", isArm: " + isArmored();
    }

    @Override
    public void style() {
        logger.debug("Bank-style");
    }

    @Override
    public void drive(Driver driver) {
        logger.debug("I am driver and I can drive the car! My name is " + driver.getName());
    }

    @Override
    public void drift(Driver driver, int meters) {
        logger.debug("My record of drifting is " + meters + " meters. What about you, " + driver.getName() + "?");
    }
}
