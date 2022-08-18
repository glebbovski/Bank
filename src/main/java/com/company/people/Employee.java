package com.company.people;

import com.company.exceptions.WrongNameOrSurnameException;
import com.company.interfaces.Openable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Employee extends Human implements Openable {
    private String position;
    private int salary;
    private static int id = 0;
    private final int currentId;
    private final Logger logger = LogManager.getLogger(Employee.class);

    public Employee() {
        Employee.id++;
        this.currentId = Employee.id;
    }

    public Employee(String name, String surname, String position, int salary) throws WrongNameOrSurnameException {
        super(name, surname);
        this.position = position;
        this.salary = salary;
        Employee.id++;
        this.currentId = Employee.id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCurrentId() {
        return this.currentId;
    }

    @Override
    public void role() {
        logger.info("This is Employee");
    }

    @Override
    public void addBankAccount() {
        logger.info("I can not open account in Bank :(");
    }

    @Override
    public void addDeposit() {
        logger.info("I can not open deposit in Bank :(");
    }

    @Override
    public void addCredit() {
        logger.info("I can not open deposit in Bank :(");
    }

    @Override
    public void addCard() {
        logger.info("I can not open card in Bank :(");
    }

    @Override
    public void addContribution() {
        logger.info("I can not add Contrinution :(");
    }

    @Override
    public int hashCode() {
        int result = super.getName().hashCode() + super.getSurname().hashCode();
        result = 31 * result + getPosition().hashCode() + getSalary();
        result = 31 * result + getCurrentId();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Employee)) return false;

        Employee employee = (Employee) obj;

        if (getPosition() != null && employee.getPosition().equals(getPosition()) &&
                getName() != null && getName().equals(employee.getName()) &&
                getSurname() != null && getSurname().equals(employee.getSurname()) &&
                getSalary() == employee.getSalary() && getCurrentId() == employee.getCurrentId()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Empoloyee{position=" + getPosition() + ", name=\'" + super.getName() + "\', surname=\'" +
                super.getSurname() + "\', salary=" + getSalary() + ", id=" + getCurrentId() + '}';

    }
}
