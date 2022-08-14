package com.company.people;

import com.company.exceptions.WrongNameOrSurnameException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Human  {
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


    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Human)) return false;

        Human human = (Human) obj;

        if(getName() != null && getName().equals(human.getName()) && getSurname() != null &&
                getSurname().equals(human.getSurname())) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Human{name=\'" + getName() + "\', surname=\'" + getSurname() + "\'}";
    }
}
