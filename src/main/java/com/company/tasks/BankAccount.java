package com.company.tasks;

public class BankAccount {
    private Currency currency;
    private int uniqueNumber;

    public BankAccount() {
    }

    public BankAccount(Currency currency, int uniqueNumber) {
        this.currency = currency;
        this.uniqueNumber = uniqueNumber;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(int uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    @Override
    public int hashCode() {
        int result = getCurrency().hashCode();
        result = result * 31 + getUniqueNumber();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof BankAccount)) return false;

        BankAccount account = (BankAccount) obj;

        if (getCurrency() != null && getCurrency().equals(account.getCurrency()) &&
                getUniqueNumber() == account.getUniqueNumber()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "BankAccount - Currency: " + getCurrency().toString() + ", Number: " + getUniqueNumber();
    }
}
