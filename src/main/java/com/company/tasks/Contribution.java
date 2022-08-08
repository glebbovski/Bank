package com.company.tasks;

public class Contribution {
    private int contributionAmount;
    private int uniqueNumber;

    public Contribution() {
    }

    public Contribution(int contributionAmount, int uniqueNumber) {
        this.contributionAmount = contributionAmount;
        this.uniqueNumber = uniqueNumber;
    }

    public int getContributionAmount() {
        return contributionAmount;
    }

    public void setContributionAmount(int contributionAmount) {
        this.contributionAmount = contributionAmount;
    }

    public int getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(int uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    @Override
    public int hashCode() {
        int result = getContributionAmount();
        result = 31 * result + getUniqueNumber();
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Contribution)) return false;

        Contribution contribution = (Contribution) obj;

        if (getUniqueNumber() == contribution.getUniqueNumber()
                && getContributionAmount() == contribution.getContributionAmount()) {
            return true;
        }

        return false;

    }

    @Override
    public String toString() {
        return "Contribution - Number: " + getUniqueNumber() + ", Amount: " + getContributionAmount();
    }
}
