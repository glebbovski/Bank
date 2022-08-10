package com.company.tasks;

import com.company.interfaces.Chipped;

import java.util.Date;

public class Card implements Chipped {
    private static int uniqueNumber = 0;
    private final int currentNumber;
    private String owner;
    private Date validity;

    public Card() {
        Card.uniqueNumber++;
        this.currentNumber = Card.uniqueNumber;
    }

    public Card(String owner, Date validity) {
        Card.uniqueNumber++;
        this.owner = owner;
        this.validity = validity;
        this.currentNumber = Card.uniqueNumber;
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

    public int getCurrentNumber() {
        return currentNumber;
    }

    @Override
    public int hashCode() {
        int result = getCurrentNumber();
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
                getValidity() != null && getValidity().equals(card.getValidity())
                && getCurrentNumber() == card.getCurrentNumber()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Card - Validity: " + getValidity().toString() + ", Owner: " + getOwner() + ", Number: " +
                getCurrentNumber();
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
