package com.company.people;

import com.company.exceptions.WrongNameOrSurnameException;
import com.company.interfaces.Openable;
import com.company.mainBank.MainSafe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankOwner extends Human implements Openable {

    private boolean isUkrainian;
    private final Logger logger = LogManager.getLogger(BankOwner.class);

    public BankOwner() {
    }

    public BankOwner(String name, String surname, boolean isUkrainian) throws WrongNameOrSurnameException {
        super(name, surname);
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
    public void openAccount() {
        logger.info("Am I need to open Account???");
    }

    @Override
    public void openDeposit() {
        logger.info("I do not need to open Deposit");
    }

    @Override
    public void openCredit() {
        logger.info("I do not need to open Credit");
    }

    @Override
    public void openCard() {
        logger.info("I do not need to open Card");
    }

    @Override
    public int hashCode() {
        int result = super.getName().hashCode();
        result = 31 * result + super.getSurname().hashCode();
        result = 31 * result + 31 * 29;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof BankOwner)) return false;

        BankOwner owner = (BankOwner) obj;

        if (getName() != null && getName().equals(owner.getName()) &&
                getSurname() != null && getSurname().equals(owner.getSurname()) &&
                isUkrainian() == owner.isUkrainian()) {
            return true;
        }

        return false;

    }

    @Override
    public String toString() {
        return "BankOwner{name=\'" + getName() + "\', surname=\'" + getSurname() + "\', ukrainian=" + isUkrainian() + '}';
    }
}
