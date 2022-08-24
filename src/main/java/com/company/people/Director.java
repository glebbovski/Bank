package com.company.people;

import com.company.exceptions.WrongNameOrSurnameException;

import java.util.Objects;

public class Director extends Employee {
    private int yearsWorkExperience;

    public Director() {
        this.setPosition("Director");
    }

    public Director(String name, String surname, String phoneNumber, int salary, int yearsWorkExperience) throws WrongNameOrSurnameException {
        super(name, surname, phoneNumber,  "Director", salary);
        this.yearsWorkExperience = yearsWorkExperience;
    }

    public int getYearsWorkExperience() {
        return yearsWorkExperience;
    }

    public void setYearsWorkExperience(int yearsWorkExperience) {
        this.yearsWorkExperience = yearsWorkExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Director director = (Director) o;
        return yearsWorkExperience == director.yearsWorkExperience;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), yearsWorkExperience);
    }

    @Override
    public String toString() {
        return super.toString() + ", yearsOfWorkExperience=" + getYearsWorkExperience() + '}';
    }
}
