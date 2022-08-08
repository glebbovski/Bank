package com.company.people;

import com.company.exceptions.WrongNameOrSurnameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Employee extends Human {

    private String position;
    private final Logger logger = LogManager.getLogger(Employee.class);

    public Employee() {
    }

    public Employee(String name, String surname, String position) throws WrongNameOrSurnameException {
        super(name, surname);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public int hashCode() {
        int result = super.getName().hashCode() + super.getSurname().hashCode();
        result = 31 * result + getPosition().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Employee)) return false;

        Employee employee = (Employee) obj;

        if (getPosition() != null && employee.getPosition().equals(getPosition()) &&
                getName() != null && getName().equals(employee.getName()) &&
                getSurname() != null && getSurname().equals(employee.getSurname())) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Empoloyee - Position: " + getPosition() + ", Name: " + super.getName() + ", Surname: " +
                super.getSurname();

    }

    @Override
    public void role() {
        logger.debug("This is Employee");
    }

    @Override
    public void openAccount() {
        logger.debug("I can not open an account in Bank :(");
    }
}
