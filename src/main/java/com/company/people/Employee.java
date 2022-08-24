package com.company.people;

import com.company.exceptions.WrongNameOrSurnameException;
import com.company.interfaces.Openable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public abstract class Employee extends Human implements Openable {
    private String position;
    private int salary;
    private static int id = 0;
    private final int currentId;
    private final Logger logger = LogManager.getLogger(Employee.class);

    {
        Employee.id++;
        this.currentId = Employee.id;
    }

    public Employee() {

    }

    public Employee(String name, String surname, String phoneNumber, String position, int salary) throws WrongNameOrSurnameException {
        super(name, surname, phoneNumber);
        this.position = position;
        this.salary = salary;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && currentId == employee.currentId && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position, salary, currentId);
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + getName() + "', surname='" + getSurname() + "', phoneNumber='"
                + getPhoneNumber() + "', " +
                "position='" + position + '\'' +
                ", salary=" + salary +
                ", currentId=" + currentId +
                '}';
    }
}
