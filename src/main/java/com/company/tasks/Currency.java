package com.company.tasks;

public enum Currency {

    USD("Dollar", "USA", 15, 20),
    HRIVNYA("HRIVNYA", "Ukraine", 20, 15),
    EURO("EURO", "Europe", 17, 18),
    FRANCS("FRANCS", "UK", 21, 19);

    private String name;
    private String country;
    private int banknoteWidth;
    private int banknoteLength;

    Currency() {
    }

    Currency(String name, String country, int banknoteWidth, int banknoteLength) {
        this.name = name;
        this.country = country;
        this.banknoteWidth = banknoteWidth;
        this.banknoteLength = banknoteLength;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getBanknoteWidth() {
        return banknoteWidth;
    }

    public int getBanknoteLength() {
        return banknoteLength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBanknoteWidth(int banknoteWidth) {
        this.banknoteWidth = banknoteWidth;
    }

    public void setBanknoteLength(int banknoteLength) {
        this.banknoteLength = banknoteLength;
    }
/*
    @Override
    public int hashCode() {
        int result = getCountry().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getBanknoteLength() + getBanknoteWidth();
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Currency)) return false;

        Currency currency = (Currency) obj;

        if (getName() != null && getName().equals(currency.getName()) &&
                getCountry() != null && getCountry().equals(currency.getCountry()) &&
                getBanknoteWidth() == currency.getBanknoteWidth() &&
                getBanknoteLength() == currency.getBanknoteLength()) {
            return true;
        }

        return false;
    }
*/
    @Override
    public String toString() {
        return "Currency{name=\'" + getName() + "\', country=\'" + getCountry() + "\', width=" + getBanknoteWidth() +
                ", length=" + getBanknoteLength() + '}';
    }
}
