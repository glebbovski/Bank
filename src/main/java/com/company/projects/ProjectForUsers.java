package com.company.projects;

import com.company.exceptions.UsersCountLimitException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public abstract class ProjectForUsers {
    private Date dateOfCreation;
    private int countOfUsers;
    private int markOfUsers;
    private final Logger logger = LogManager.getLogger(ProjectForUsers.class);

    public ProjectForUsers() {

    }

    public ProjectForUsers(Date dateOfCreation, int countOfUsers, int markOfUsers) {
        boolean check = checkCountOfUsers(countOfUsers);
        if (check) {
            throw new UsersCountLimitException("TOO MANY USERS!!!");
        }
        this.dateOfCreation = dateOfCreation;
        this.countOfUsers = countOfUsers;
        this.markOfUsers = markOfUsers;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public int getCountOfUsers() {
        return countOfUsers;
    }

    public void setCountOfUsers(int countOfUsers) {
        boolean check = checkCountOfUsers(countOfUsers);
        if (check) {
            throw new UsersCountLimitException("TOO MANY USERS!!!");
        }
        this.countOfUsers = countOfUsers;
    }

    public int getMarkOfUsers() {
        return markOfUsers;
    }

    public void setMarkOfUsers(int markOfUsers) {
        this.markOfUsers = markOfUsers;
    }

    public abstract void launch();

    public void closing() {
        logger.info("Goodbye!");
    }

    private boolean checkCountOfUsers(int countOfUsers) {
        return countOfUsers > 45_000;
    }

    @Override
    public int hashCode() {
        int result = getDateOfCreation().hashCode();
        result = 31 * result + getCountOfUsers() + getMarkOfUsers();
        result = result * 29;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof ProjectForUsers)) return false;

        ProjectForUsers project = (ProjectForUsers) obj;

        if (getDateOfCreation() != null && getDateOfCreation().equals(project.getDateOfCreation()) &&
                getMarkOfUsers() == project.getMarkOfUsers() && getCountOfUsers() == project.getCountOfUsers()) {

            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "ProjectForUsers – DateOfCreation: " + getDateOfCreation().toString() +
                ", CountOfUsers: " + getCountOfUsers() + ", MarkOfUsers: " + getMarkOfUsers();
    }
}
