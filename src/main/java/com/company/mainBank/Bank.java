package com.company.mainBank;

import com.company.people.Employee;
import com.company.people.BankOwner;
import com.company.projects.MobileApp;
import com.company.people.User;
import com.company.projects.Website;


import java.util.Arrays;

public class Bank {

    private String bankName;
    private User[] users;
    private Employee[] employees;
    private MainSafe mainSafe;
    private BankCar[] bankCars;
    private BankOwner bankOwner;
    private Website website;
    private MobileApp mobileApp;
    private IssuePoint[] issuePoints;

    public Bank() {
    }

    public Bank(String bankName, User[] users, Employee[] employees, MainSafe mainSafe, BankCar[] bankCars,
                BankOwner bankOwner, Website website, MobileApp mobileApp, IssuePoint[] issuePoints) {
        this.bankName = bankName;
        this.users = users;
        this.employees = employees;
        this.mainSafe = mainSafe;
        this.bankCars = bankCars;
        this.bankOwner = bankOwner;
        this.website = website;
        this.mobileApp = mobileApp;
        this.issuePoints = issuePoints;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public MainSafe getMainSafe() {
        return mainSafe;
    }

    public void setMainSafe(MainSafe mainSafe) {
        this.mainSafe = mainSafe;
    }

    public BankCar[] getBankCars() {
        return bankCars;
    }

    public void setBankCars(BankCar[] bankCars) {
        this.bankCars = bankCars;
    }

    public BankOwner getBankOwner() {
        return bankOwner;
    }

    public void setBankOwner(BankOwner bankOwner) {
        this.bankOwner = bankOwner;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    public MobileApp getMobileApp() {
        return mobileApp;
    }

    public void setMobileApp(MobileApp mobileApp) {
        this.mobileApp = mobileApp;
    }

    public IssuePoint[] getIssuePoints() {
        return issuePoints;
    }

    public void setIssuePoints(IssuePoint[] issuePoints) {
        this.issuePoints = issuePoints;
    }

    @Override
    public int hashCode() {
        int result = getBankName().hashCode();
        result = 31 * result + Arrays.hashCode(getUsers());
        result = 31 * result + Arrays.hashCode(getEmployees()) + 31 * getMainSafe().hashCode();
        result = 31 * result + Arrays.hashCode(getBankCars()) + 31 * getBankOwner().hashCode();
        result = 31 * result + getWebsite().hashCode() + getMobileApp().hashCode();
        result = 31 * result + Arrays.hashCode(getIssuePoints());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Bank)) return false;

        Bank bank = (Bank) obj;

        if (getBankName() != null && getBankName().equals(bank.getBankName()) &&
                getUsers() != null && Arrays.equals(getUsers(), bank.getUsers()) &&
                getEmployees() != null && Arrays.equals(getEmployees(), bank.getEmployees()) &&
                getMainSafe() != null && getMainSafe().equals(bank.getMainSafe()) &&
                getBankCars() != null && Arrays.equals(getBankCars(), bank.getBankCars()) &&
                getWebsite() != null && getWebsite().equals(bank.getWebsite()) &&
                getMobileApp() != null && getMobileApp().equals(bank.getMobileApp()) &&
                getIssuePoints() != null && Arrays.equals(getIssuePoints(), bank.getIssuePoints())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bank - Name: " + getBankName() + ", Users: " + Arrays.toString(getUsers()) + ", Employees: "
                + Arrays.toString(getEmployees()) + ", MainSafe: " + getMainSafe() + ", BankCars: "
                + Arrays.toString(getBankCars()) + ", Website: " + getWebsite() + ", MobileApp: "
                + getMobileApp() + ", IssuePoints: " + Arrays.toString(getIssuePoints());
    }

}
