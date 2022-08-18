package com.company.tasks;

import com.company.interfaces.Chipped;
import com.company.people.User;

import java.util.Date;
import java.util.Objects;

public class Card implements Chipped {
    private static int uniqueNumber = 0;
    private final int currentNumber;
    private Date validity;
    private String name;
    private String surname;


    {
        Card.uniqueNumber++;
        this.currentNumber = Card.uniqueNumber;
    }

    public Card() {

    }

    public Card(Date validity) {
        this.validity = validity;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(validity, card.validity) && Objects.equals(name, card.name) && Objects.equals(surname, card.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(validity, name, surname);
    }

    @Override
    public String toString() {
        return "Card{" +
                "currentNumber=" + currentNumber +
                ", validity=" + validity +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
