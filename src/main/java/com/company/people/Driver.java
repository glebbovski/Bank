package com.company.people;

import com.company.exceptions.WrongNameOrSurnameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;


public class Driver extends Employee {
    private boolean hasDriverLicense;
    private final Logger logger = LogManager.getLogger(Driver.class);

    public Driver() {
        this.setPosition("Driver");
    }

    public Driver(String name, String surname, String phoneNumber, int salary, boolean hasDriverLicense) throws WrongNameOrSurnameException {
        super(name, surname, phoneNumber, "Driver", salary);
        this.hasDriverLicense = hasDriverLicense;
    }

    public boolean isHasDriverLicense() {
        return hasDriverLicense;
    }

    public void setHasDriverLicense(boolean hasDriverLicense) {
        this.hasDriverLicense = hasDriverLicense;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Driver driver = (Driver) o;
        return hasDriverLicense == driver.hasDriverLicense;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasDriverLicense);
    }

    @Override
    public String toString() {
        return super.toString() + ", hasDriverLicense=" + isHasDriverLicense() + '}';
    }

}
