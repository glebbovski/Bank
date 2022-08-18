package com.company.mainBank;

public enum BankCarMarks {

    VOLKSWAGEN("Germany", "Volkswagen"),
    MERCEDES("Germany", "Mercedes"),
    NISSAN("Japan", "Nissan");


    private String country;
    private String name;

    BankCarMarks() {
    }

    BankCarMarks(String country, String name) {
        this.country = country;
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "BankCarMarks{" +
                "country='" + country + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
