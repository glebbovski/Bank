package com.company.mainBank;

import com.company.people.Employee;
import com.company.people.BankOwner;
import com.company.projects.MobileApp;
import com.company.people.User;
import com.company.projects.Website;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Bank {

    private String bankName;
    private LinkedList<User> users;
    private ArrayList<Employee> employees;
    private MainSafe mainSafe;
    private LinkedList<BankCar> bankCars;
    private BankOwner bankOwner;
    private Website website;
    private MobileApp mobileApp;
    private ArrayList<IssuePoint> issuePoints;

    public Bank() {
    }

    public Bank(String bankName, LinkedList<User> users, ArrayList<Employee> employees, MainSafe mainSafe, LinkedList<BankCar> bankCars,
                BankOwner bankOwner, Website website, MobileApp mobileApp, ArrayList<IssuePoint> issuePoints) {
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

    public LinkedList<User> getUsers() {
        return users;
    }

    public void setUsers(LinkedList<User> users) {
        this.users = users;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public MainSafe getMainSafe() {
        return mainSafe;
    }

    public void setMainSafe(MainSafe mainSafe) {
        this.mainSafe = mainSafe;
    }

    public LinkedList<BankCar> getBankCars() {
        return bankCars;
    }

    public void setBankCars(LinkedList<BankCar> bankCars) {
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

    public ArrayList<IssuePoint> getIssuePoints() {
        return issuePoints;
    }

    public void setIssuePoints(ArrayList<IssuePoint> issuePoints) {
        this.issuePoints = issuePoints;
    }

    @Override
    public int hashCode() {
        int result = getBankName().hashCode();
        result = 31 * result + getUsers().hashCode();
        result = 31 * result + getEmployees().hashCode() + 31 * getMainSafe().hashCode();
        result = 31 * result + getBankCars().hashCode() + 31 * getBankOwner().hashCode();
        result = 31 * result + getWebsite().hashCode() + getMobileApp().hashCode();
        result = 31 * result + getIssuePoints().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Bank)) return false;

        Bank bank = (Bank) obj;

        if (getBankName() != null && getBankName().equals(bank.getBankName()) &&
                getUsers() != null && getUsers().equals(bank.getUsers()) &&
                getEmployees() != null && getEmployees().equals(bank.getEmployees()) &&
                getMainSafe() != null && getMainSafe().equals(bank.getMainSafe()) &&
                getBankCars() != null && getBankCars().equals(bank.getBankCars()) &&
                getWebsite() != null && getWebsite().equals(bank.getWebsite()) &&
                getMobileApp() != null && getMobileApp().equals(bank.getMobileApp()) &&
                getIssuePoints() != null && getIssuePoints().equals(bank.getIssuePoints())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bank - Name: " + getBankName() + ", Users: " + getUsers().toString() + ", Employees: "
                + getEmployees().toString() + ", MainSafe: " + getMainSafe() + ", BankCars: "
                + getBankCars().toString() + ", Website: " + getWebsite() + ", MobileApp: "
                + getMobileApp() + ", IssuePoints: " + getIssuePoints().toString();
    }

}
