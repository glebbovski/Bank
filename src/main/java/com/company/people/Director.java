package com.company.people;

import com.company.exceptions.WrongNameOrSurnameException;

public class Director extends Employee {
    private int yearsWorkExperience;

    public Director() {
        this.setPosition("Director");
    }

    public Director(String name, String surname, int salary, int yearsWorkExperience) throws WrongNameOrSurnameException {
        super(name, surname, "Director", salary);
        this.yearsWorkExperience = yearsWorkExperience;
    }

    public int getYearsWorkExperience() {
        return yearsWorkExperience;
    }

    public void setYearsWorkExperience(int yearsWorkExperience) {
        this.yearsWorkExperience = yearsWorkExperience;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode() * 31 + 1;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Director)) return false;

        Director director = (Director) obj;

        if (getName() != null && getName().equals(director.getName()) &&
                getSurname() != null && getSurname().equals(director.getSurname()) &&
                getYearsWorkExperience() == director.getYearsWorkExperience()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", yearsOfWorkExperience=" + getYearsWorkExperience() + '}';
    }
}
