package com.company.tasks;

import com.company.interfaces.Chipped;
import com.company.people.User;

import java.util.Date;

public class Card implements Chipped {
    private static int uniqueNumber = 0;
    private final int currentNumber;
    private Date validity;

    public Card() {
        Card.uniqueNumber++;
        this.currentNumber = Card.uniqueNumber;
    }

    public Card(Date validity) {
        Card.uniqueNumber++;
        this.validity = validity;
        this.currentNumber = Card.uniqueNumber;
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
    public boolean hasMicrochip(Card card) {
        if (card.getCurrentNumber() >= 124) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = getCurrentNumber();
        result = 31 * result + getValidity().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Card)) return false;

        Card card = (Card) obj;

        if ( getValidity() != null && getValidity().equals(card.getValidity())
                && getCurrentNumber() == card.getCurrentNumber()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Card{validity=\'" + getValidity().toString() + "\', number=" +
                getCurrentNumber() + '}';
    }

}
