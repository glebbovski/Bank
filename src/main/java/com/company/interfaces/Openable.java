package com.company.interfaces;

import java.text.ParseException;

public interface Openable {
    void addBankAccount();
    void addDeposit();
    void addCredit();
    void addCard() throws ParseException;
    void addContribution();
}
