package com.company.mainBank;

import com.company.Main;
import com.company.interfaces.Driveable;
import com.company.people.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BankCar extends Car {
    private boolean isPassenger;
    private boolean isArmored;
    private BankCarMarks bankCarMark;
    private final Logger logger = LogManager.getLogger(BankCar.class);

    public BankCar() {

    }

    public BankCar(String color, BankCarMarks bankCarMark, int year, boolean isPassenger, boolean isArmored) {
        super(color, year);
        this.bankCarMark = bankCarMark;
        this.isPassenger = isPassenger;
        this.isArmored = isArmored;
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

    public BankCarMarks getBankCarMark() {
        return bankCarMark;
    }

    public void setBankCarMark(BankCarMarks bankCarMark) {
        this.bankCarMark = bankCarMark;
    }

    @Override
    public void style() {
        logger.info("BankCar-style");
    }

    @Override
    public void drive(Driver driver) {
        logger.info("I am driver and I can drive the BankCar! My name is " + driver.getName());
    }

    @Override
    public int hashCode() {
        int result = super.getColor().hashCode();
        result = 31 * result;
        result = 31 * result + getCurrentNumber() + getDriver().hashCode();
        result = 31 * result + getYear();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof BankCar)) return false;

        BankCar car = (BankCar) obj;

        if (getColor() != null && getColor().equals(car.getColor()) &&
                getCurrentNumber() == car.getCurrentNumber() && isArmored() == car.isArmored() &&
                isPassenger() == car.isPassenger() && getDriver() != null && getDriver() == car.getDriver() &&
                getYear() == car.getYear() && getBankCarMark() != null &&
                getBankCarMark().equals(car.getBankCarMark())) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "BankCar{color=\'" + getColor() + "\', mark=" + getBankCarMark() + ", number=" + getCurrentNumber() +
                ", isPass=" + isPassenger() + ", isArm=" + isArmored() + ", driver=" + getDriver() +
                ", year=" + getYear() + '}';
    }


}
