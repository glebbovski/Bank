package com.company.people;

import com.company.exceptions.PhoneNumberException;
import com.company.exceptions.WrongNameOrSurnameException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Human  {
    private String name;
    private String surname;
    private String phoneNumber;

    public Human() {

    }

    public Human(String name, String surname, String phoneNumber) throws WrongNameOrSurnameException, PhoneNumberException {
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

        if (!checkPhoneNumber(phoneNumber)) {
            throw new PhoneNumberException("Wrong Phone Number");
        }
        this.phoneNumber = phoneNumber;

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!checkPhoneNumber(phoneNumber)) {
            throw new PhoneNumberException("Wrong Phone Number");
        }
        this.phoneNumber = phoneNumber;
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

    public boolean checkPhoneNumber(String phoneNumber) {
        String regx = "(?=.*\\+[0-9]{3}\\s?[0-9]{2}\\s?[0-9]{3}\\s?[0-9]{4,5}$)";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(phoneNumber, human.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phoneNumber);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
