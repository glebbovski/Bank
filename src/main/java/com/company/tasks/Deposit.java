package com.company.tasks;

public class Deposit {
    private int depositAmount;
    private String ownerOfDeposit;

    public Deposit() {
    }

    public Deposit(int depositAmount, String ownerOfDeposit) {
        this.depositAmount = depositAmount;
        this.ownerOfDeposit = ownerOfDeposit;
    }

    public int getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(int depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getOwnerOfDeposit() {
        return ownerOfDeposit;
    }

    public void setOwnerOfDeposit(String ownerOfDeposit) {
        this.ownerOfDeposit = ownerOfDeposit;
    }

    @Override
    public int hashCode() {
        int result = getDepositAmount();
        result = result * 31 + getOwnerOfDeposit().hashCode();
        return result * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Deposit)) return false;

        Deposit deposit = (Deposit) obj;

        if (getOwnerOfDeposit() != null &&
                getOwnerOfDeposit().equals(deposit.getOwnerOfDeposit()) &&
                getDepositAmount() == deposit.getDepositAmount()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Deposit - Owner: " + getOwnerOfDeposit() + ", Amount: " + getDepositAmount();
    }
}
