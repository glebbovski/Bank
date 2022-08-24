package com.company.people;

import com.company.exceptions.WrongNameOrSurnameException;
import com.company.interfaces.Openable;
import com.company.mainBank.MainSafe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class BankOwner extends Human implements Openable {

    private boolean isUkrainian;
    private final Logger logger = LogManager.getLogger(BankOwner.class);

    public BankOwner() {
    }

    public BankOwner(String name, String surname, String phoneNumber, boolean isUkrainian) throws WrongNameOrSurnameException {
        super(name, surname, phoneNumber);
        this.isUkrainian = isUkrainian;
    }


    public boolean isUkrainian() {
        return isUkrainian;
    }

    public void setUkrainian(boolean ukrainian) {
        isUkrainian = ukrainian;
    }

    @Override
    public void role() {
        logger.info("This is BankOwner");
    }

    @Override
    public void addBankAccount() {
        logger.info("Am I need to open Account???");
    }

    @Override
    public void addDeposit() {
        logger.info("I do not need to open Deposit");
    }

    @Override
    public void addCredit() {
        logger.info("I do not need to open Credit");
    }

    @Override
    public void addCard() {
        logger.info("I do not need to open Card");
    }

    @Override
    public void addContribution() {
        logger.info("I do not need to add Cotribution");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BankOwner bankOwner = (BankOwner) o;
        return isUkrainian == bankOwner.isUkrainian;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isUkrainian);
    }

    @Override
    public String toString() {
        return super.toString() + ", " +
                "isUkrainian=" + isUkrainian +
                '}';
    }
}
