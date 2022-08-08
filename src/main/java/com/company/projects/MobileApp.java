package com.company.projects;

import java.util.Arrays;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MobileApp extends ProjectForUsers {
    private boolean isWorkingNow;
    private int appSize;
    private String[] whereCanBeFind;
    private final Logger logger = LogManager.getLogger(ProjectForUsers.class);


    public MobileApp() {
    }

    public MobileApp(Date dateOfCreation, int countOfUsers, int markOfUsers, boolean isWorkingNow, int appSize, String[] whereCanBeFind) {
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

    public String[] getWhereCanBeFind() {
        return whereCanBeFind;
    }

    public void setWhereCanBeFind(String[] whereCanBeFind) {
        this.whereCanBeFind = whereCanBeFind;
    }

    @Override
    public int hashCode() {
        int result = super.getDateOfCreation().hashCode();
        result = 31 * result + super.getCountOfUsers() + super.getMarkOfUsers();
        result = 31 * result + getAppSize() + getWhereCanBeFind().length;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof MobileApp)) return false;

        MobileApp app = (MobileApp) obj;

        if (super.getCountOfUsers() == app.getCountOfUsers() && super.getMarkOfUsers() == app.getMarkOfUsers() &&
                super.getDateOfCreation() != null && super.getDateOfCreation().equals(app.getDateOfCreation()) &&
                getWhereCanBeFind() != null && Arrays.equals(getWhereCanBeFind(), app.getWhereCanBeFind())
                && getAppSize() == app.getAppSize()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "MobileApp - Date: " + super.getDateOfCreation().toString() + ", Count: " + super.getCountOfUsers() +
                ", Mark: " + super.getMarkOfUsers() + " AppSize: " + getAppSize() + ", You can find in: " +
                Arrays.toString(getWhereCanBeFind());
    }

    @Override
    public void launch() {
        logger.debug("MobileApp is launching...");
    }
}
