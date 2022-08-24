package com.company.people;

import com.company.exceptions.WrongNameOrSurnameException;

import java.util.Objects;

public class Cashier extends Employee {
    private int cashDeskNumber;

    public Cashier() {
        this.setPosition("Cashier");
    }

    public Cashier(String name, String surname,String phoneNumber, int salary, int cashDeskNumber) throws WrongNameOrSurnameException {
        super(name, surname, phoneNumber, "Cashier", salary);
        this.cashDeskNumber = cashDeskNumber;
    }

    public int getCashDeskNumber() {
        return cashDeskNumber;
    }

    public void setCashDeskNumber(int cashDeskNumber) {
        this.cashDeskNumber = cashDeskNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cashier cashier = (Cashier) o;
        return cashDeskNumber == cashier.cashDeskNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cashDeskNumber);
    }

    @Override
    public String toString() {
        return super.toString() + ", cashDeskNumber=" + getCashDeskNumber() + '}';
    }
}
