package com.company.tasks;

import com.company.interfaces.Openable;

public class Contribution {
    private int contributionAmount;
    private static int uniqueNumber;
    private final int currentNumber;

    {
        Contribution.uniqueNumber++;
        this.currentNumber = Contribution.uniqueNumber;
    }

    public Contribution() {
    }

    public Contribution(int contributionAmount) {
        this.contributionAmount = contributionAmount;
    }

    public int getContributionAmount() {
        return contributionAmount;
    }

    public void setContributionAmount(int contributionAmount) {
        this.contributionAmount = contributionAmount;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    @Override
    public int hashCode() {
        int result = getContributionAmount();
        result = 31 * result + getCurrentNumber();
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Contribution)) return false;

        Contribution contribution = (Contribution) obj;

        if (getCurrentNumber() == contribution.getCurrentNumber()
                && getContributionAmount() == contribution.getContributionAmount()) {
            return true;
        }

        return false;

    }

    @Override
    public String toString() {
        return "Contribution{number=" + getCurrentNumber() + ", amount=" + getContributionAmount() + '}';
    }
}
