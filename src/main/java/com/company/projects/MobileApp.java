package com.company.projects;

import java.util.Arrays;
import java.util.Date;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MobileApp extends ProjectForUsers {
    private boolean isWorkingNow;
    private int appSize;
    private TreeSet<String> whereCanBeFind;
    private final Logger logger = LogManager.getLogger(ProjectForUsers.class);


    public MobileApp() {
    }

    public MobileApp(Date dateOfCreation, int countOfUsers, int markOfUsers, boolean isWorkingNow, int appSize, TreeSet<String> whereCanBeFind) {
        super(dateOfCreation, countOfUsers, markOfUsers);
        this.isWorkingNow = isWorkingNow;
        this.appSize = appSize;
        this.whereCanBeFind = whereCanBeFind;
    }

    public boolean isWorkingNow() {
        return isWorkingNow;
    }

    public void setWorkingNow(boolean workingNow) {
        isWorkingNow = workingNow;
    }

    public int getAppSize() {
        return appSize;
    }

    public void setAppSize(int appSize) {
        this.appSize = appSize;
    }

    public TreeSet<String> getWhereCanBeFind() {
        return whereCanBeFind;
    }

    public void setWhereCanBeFind(TreeSet<String> whereCanBeFind) {
        this.whereCanBeFind = whereCanBeFind;
    }

    @Override
    public void launch() {
        logger.info("MobileApp is launching...");
    }

    @Override
    public int hashCode() {
        int result = super.getDateOfCreation().hashCode();
        result = 31 * result + super.getCountOfUsers() + super.getMarkOfUsers();
        result = 31 * result + getAppSize() + getWhereCanBeFind().size();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof MobileApp)) return false;

        MobileApp app = (MobileApp) obj;

        if (super.getCountOfUsers() == app.getCountOfUsers() && super.getMarkOfUsers() == app.getMarkOfUsers() &&
                super.getDateOfCreation() != null && super.getDateOfCreation().equals(app.getDateOfCreation()) &&
                getWhereCanBeFind() != null && getWhereCanBeFind().equals(app.getWhereCanBeFind())
                && getAppSize() == app.getAppSize()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return  super.toString() + ", appSize=" + getAppSize() + ", WhereCanBeFound=" +
                getWhereCanBeFind().toString() + '}';
    }
}
