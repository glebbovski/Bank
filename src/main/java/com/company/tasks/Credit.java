package com.company.tasks;

import com.company.exceptions.CreditLimitException;

import java.util.Date;

public class Credit {
    private int currentCredit;
    private Date lastPaymentDate;

    public Credit() {
    }

    public Credit(int currentCredit, Date lastPaymentDate) {
        boolean creditCheck = exceedingLimit(currentCredit);
        if (creditCheck) {
            throw new CreditLimitException("Sorry, your credit has reached the limit!");
        }
        this.currentCredit = currentCredit;
        this.lastPaymentDate = lastPaymentDate;
    }

    public int getCurrentCredit() {
        return currentCredit;
    }

    public void setCurrentCredit(int currentCredit) {
        boolean creditCheck = exceedingLimit(currentCredit);
        if (creditCheck) {
            throw new CreditLimitException("Sorry, your credit has reached the limit!");
        }
        this.currentCredit = currentCredit;
    }

    public Date getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(Date lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    private boolean exceedingLimit(int currentCredit) {
        return currentCredit > 500_000;
    }

    @Override
    public int hashCode() {
        int result = getCurrentCredit();
        result = 31 * result + getLastPaymentDate().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Credit)) return false;

        Credit credit = (Credit) obj;

        if (getLastPaymentDate() != null && getLastPaymentDate().equals(credit.getLastPaymentDate()) &&
                getCurrentCredit() == credit.getCurrentCredit()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Credit{current=" + getCurrentCredit() + ", lastPayment=\'" + getLastPaymentDate().toString() + "\'}";
    }

}
