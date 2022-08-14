package com.company.tasks;

import com.company.people.User;

public class Deposit {
    private int depositAmount;

    public Deposit() {
    }

    public Deposit(int depositAmount) {
        this.depositAmount = depositAmount;
    }

    public int getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(int depositAmount) {
        this.depositAmount = depositAmount;
    }



    @Override
    public int hashCode() {
        int result = getDepositAmount();
        return result * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Deposit)) return false;

        Deposit deposit = (Deposit) obj;

        if (getDepositAmount() == deposit.getDepositAmount()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Deposit{amount=" + getDepositAmount() + '}';
    }
}
