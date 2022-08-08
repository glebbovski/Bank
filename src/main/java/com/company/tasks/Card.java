package com.company.tasks;

import com.company.interfaces.Chipped;

import java.util.Date;

public class Card implements Chipped {
    private int uniqueNumber;
    private String owner;
    private Date validity;

    public Card() {
    }

    public Card(int uniqueNumber, String owner, Date validity) {
        this.uniqueNumber = uniqueNumber;
        this.owner = owner;
        this.validity = validity;
    }

    public int getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(int uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    @Override
    public int hashCode() {
        int result = getUniqueNumber();
        result = 31 * result + getOwner().hashCode();
        result = 31 * result + getValidity().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Card)) return false;

        Card card = (Card) obj;

        if (getOwner() != null && getOwner().equals(card.getOwner()) &&
                getValidity() != null && getValidity().equals(card.getValidity()) &&
                getUniqueNumber() == card.getUniqueNumber()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Card - Validity: " + getValidity().toString() + ", Owner: " + getOwner() + ", Number: " +
                getUniqueNumber();
    }

    @Override
    public boolean hasMicrochip(Card card) {
        if (card.owner.equals("Gleb")) {
            return true;
        } else {
            return false;
        }
    }
}
