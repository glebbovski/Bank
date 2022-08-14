package com.company.people;

import com.company.exceptions.WrongNameOrSurnameException;

public class Cashier extends Employee {
    private int cashDeskNumber;

    public Cashier() {
        this.setPosition("Cashier");
    }

    public Cashier(String name, String surname, int salary, int cashDeskNumber) throws WrongNameOrSurnameException {
        super(name, surname, "Cashier", salary);
        this.cashDeskNumber = cashDeskNumber;
    }

    public int getCashDeskNumber() {
        return cashDeskNumber;
    }

    public void setCashDeskNumber(int cashDeskNumber) {
        this.cashDeskNumber = cashDeskNumber;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode() * 31 + 27;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Cashier)) return false;

        Cashier cashier = (Cashier) obj;

        if (getName() != null && getName().equals(cashier.getName()) &&
                getSurname() != null && getSurname().equals(cashier.getSurname()) &&
                getCashDeskNumber() == cashier.getCashDeskNumber()) {
            return true;
        }

        return false;

    }

    @Override
    public String toString() {
        return super.toString() + ", cashDeskNumber=" + getCashDeskNumber() + '}';
    }
}
