package com.company.people;

import com.company.exceptions.WrongNameOrSurnameException;
import com.company.interfaces.AccountOpenable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Human implements AccountOpenable {
    private String name;
    private String surname;

    public Human() {

    }

    public Human(String name, String surname) throws WrongNameOrSurnameException {
        boolean checkName = checkNameSurnameRegex(name);
        if (!checkName) {
            throw new WrongNameOrSurnameException("Wrong style for name");
        }
        checkName = checkNameSurnameRegex(surname);
        if (!checkName) {
            throw new WrongNameOrSurnameException("Wrong style for surname");
        }
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws WrongNameOrSurnameException {
        boolean checkName = checkNameSurnameRegex(name);
        if (!checkName) {
            throw new WrongNameOrSurnameException("Wrong style for name");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws WrongNameOrSurnameException {
        boolean checkName = checkNameSurnameRegex(surname);
        if (!checkName) {
            throw new WrongNameOrSurnameException("Wrong style for name");
        }
        this.surname = surname;
    }

    public abstract void role();

    private boolean checkNameSurnameRegex(String str) {
        String regx = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
