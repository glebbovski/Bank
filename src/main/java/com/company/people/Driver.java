package com.company.people;

import com.company.exceptions.WrongNameOrSurnameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Driver extends Employee {
    private boolean hasDriverLicense;
    private final Logger logger = LogManager.getLogger(Driver.class);

    public Driver() {
        this.setPosition("Driver");
    }

    public Driver(String name, String surname, int salary, boolean hasDriverLicense) throws WrongNameOrSurnameException {
        super(name, surname, "Driver", salary);
        this.hasDriverLicense = hasDriverLicense;
    }

    public boolean isHasDriverLicense() {
        return hasDriverLicense;
    }

    public void setHasDriverLicense(boolean hasDriverLicense) {
        this.hasDriverLicense = hasDriverLicense;
    }



    @Override
    public int hashCode() {
        int result = super.hashCode() * 31 + 29;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Driver)) return false;

        Driver driver = (Driver) obj;

        if (getName() != null && getName().equals(driver.getName()) &&
                getSurname() != null && getSurname().equals(driver.getSurname()) &&
                isHasDriverLicense() == driver.isHasDriverLicense()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", hasDriverLicense: " + isHasDriverLicense();
    }

}
