package com.company.people;

import com.company.exceptions.WrongNameOrSurnameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Driver extends Human {

    private boolean hasDriverLicense;
    private final Logger logger = LogManager.getLogger(Driver.class);

    public Driver() {

    }

    public Driver(String name, String surname, boolean hasDriverLicense) throws WrongNameOrSurnameException {
        super(name, surname);
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
        int result = super.getName().hashCode();
        result = 31 * result + super.getSurname().hashCode();
        result = 31 * result + 31 * 99;
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
        return "Driver - Name: " + getName() + ", Surname: " + getSurname() + ", HasDriverLicense: " +
                isHasDriverLicense();
    }

    @Override
    public void role() {
        logger.debug("This is a driver!");
    }

    @Override
    public void openAccount() {
        logger.debug("I am Driver! I can not open an account in Bank! :(");
    }
}
