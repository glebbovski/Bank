package com.company.tasks;

public class BankAccount {
    private Currency currency;
    private static int uniqueNumber = 0;
    private final int currentNumber;

    {
        BankAccount.uniqueNumber++;
        this.currentNumber = BankAccount.uniqueNumber;
    }

    public BankAccount() {
    }

    public BankAccount(Currency currency) {
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getCurrentNumber() {
        return this.currentNumber;
    }


    @Override
    public int hashCode() {
        int result = getCurrency().hashCode();
        result = result * 31 + getCurrentNumber();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof BankAccount)) return false;

        BankAccount account = (BankAccount) obj;

        if (getCurrency() != null && getCurrency().equals(account.getCurrency()) &&
                getCurrentNumber() == account.getCurrentNumber()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "BankAccount{currency=" + getCurrency().toString() + ", number=" + getCurrentNumber() + '}';
    }
}
