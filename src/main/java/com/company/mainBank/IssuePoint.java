package com.company.mainBank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.TreeSet;

public class IssuePoint {
    private String address;
    private TreeSet<Date> addmissionDays;

    public IssuePoint() {
    }

    public IssuePoint(String address, TreeSet<Date> addmissionDays) {
        this.address = address;
        this.addmissionDays = addmissionDays;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TreeSet<Date> getAddmissionDays() {
        return addmissionDays;
    }

    public void setAddmissionDays(TreeSet<Date> addmissionDays) {
        this.addmissionDays = addmissionDays;
    }

    @Override
    public int hashCode() {
        int result = getAddress().hashCode();
        result = result * 31 + getAddmissionDays().size();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof IssuePoint)) return false;

        IssuePoint point = (IssuePoint) obj;

        if (getAddress() != null && getAddress().equals(point.getAddress()) &&
                getAddmissionDays() != null && getAddmissionDays().equals(point.getAddmissionDays())) {
            return true;
        }

        return false;

    }

    @Override
    public String toString() {
        return "IssuePoint{address=" + getAddress() + ", addmissionDays=" + getAddmissionDays().toString() + '}';
    }
}
