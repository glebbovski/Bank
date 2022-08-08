package com.company.mainBank;

import java.util.Arrays;
import java.util.Date;

public class IssuePoint {
    private String address;
    private Date[] addmissionDays;

    public IssuePoint() {
    }

    public IssuePoint(String address, Date[] addmissionDays) {
        this.address = address;
        this.addmissionDays = addmissionDays;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date[] getAddmissionDays() {
        return addmissionDays;
    }

    public void setAddmissionDays(Date[] addmissionDays) {
        this.addmissionDays = addmissionDays;
    }

    @Override
    public int hashCode() {
        int result = getAddress().hashCode();
        result = result * 31 + getAddmissionDays().length;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof IssuePoint)) return false;

        IssuePoint point = (IssuePoint) obj;

        if (getAddress() != null && getAddress().equals(point.getAddress()) &&
                getAddmissionDays() != null && Arrays.equals(getAddmissionDays(), point.getAddmissionDays())) {
            return true;
        }

        return false;

    }

    @Override
    public String toString() {
        return "IssuePoint - Address: " + getAddress() + ", Addmission Days: " + Arrays.toString(getAddmissionDays());
    }
}
