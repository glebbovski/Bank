package com.company.people;

import com.company.exceptions.PhoneNumberException;
import com.company.exceptions.WrongNameOrSurnameException;
import com.company.interfaces.Openable;
import com.company.tasks.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import  com.company.tasks.*;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User extends Human implements Openable {
    private static int id = 0;
    private final int currentId;
    private String phoneNumber;
    private BankAccount bankAccount;
    private Credit credit;
    private Card card;
    private Contribution contribution;
    private Deposit deposit;
    private final Logger logger = LogManager.getLogger(User.class);

    public User() {
        User.id++;
        this.currentId = User.id;
    }

    public User(String name, String surname, String phoneNumber, BankAccount bankAccount, Credit credit,
                Card card, Contribution contribution, Deposit deposit) throws WrongNameOrSurnameException {
        super(name, surname);

        if (!checkPhoneNumber(phoneNumber)) {
            throw new PhoneNumberException("Wrong Phone Number");
        }
        this.phoneNumber = phoneNumber;
        this.bankAccount = bankAccount;
        this.credit = credit;
        this.card = card;
        this.contribution = contribution;
        this.deposit = deposit;
        User.id++;
        this.currentId = User.id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!checkPhoneNumber(phoneNumber)) {
            throw new PhoneNumberException("Wrong Phone Number");
        }
        this.phoneNumber = phoneNumber;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Contribution getContribution() {
        return contribution;
    }

    public void setContribution(Contribution contribution) {
        this.contribution = contribution;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public int getCurrentId() {
        return this.currentId;
    }

    @Override
    public void role() {
        logger.info("This is User");
    }

    @Override
    public void openAccount() {
        logger.info("I can open account in Bank if I did not do this before! :)");
        if (this.bankAccount == null) {
            this.bankAccount = new BankAccount(Currency.EURO);
        }
    }

    @Override
    public void openDeposit() {
        logger.info("I can open deposit in Bank if I did not do this before! :)");
        if (this.deposit == null) {
            this.deposit = new Deposit(20_000);
        }
    }

    @Override
    public void openCredit() {
        logger.info("I can open credit in Bank if I did not do this before and if i did not exceed the limit! :)");
        if (this.credit == null) {
            this.credit = new Credit(90_000, new Date());
        }
    }

    @Override
    public void openCard() {
        logger.info("I can open card in Bank if I did not do this before! :)");
        if (this.card == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.YEAR, 3); // card for 3 years
            this.card = new Card(calendar.getTime());
        }
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        String regx = "(?=.*\\+[0-9]{3}\\s?[0-9]{2}\\s?[0-9]{3}\\s?[0-9]{4,5}$)";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }

    @Override
    public int hashCode() {
        int result = super.getName().hashCode() + super.getSurname().hashCode();
        result = result * 31 + getPhoneNumber().hashCode() + getBankAccount().hashCode();
        result = 31 * result + getCard().hashCode() + getCredit().hashCode();
        result = 31 * result + getContribution().hashCode() + getDeposit().hashCode() + getCurrentId();
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof User)) return false;

        User user = (User) obj;

        if (super.getName().equals(user.getName()) && super.getSurname().equals(user.getSurname()) &&
                getPhoneNumber().equals(user.getPhoneNumber()) &&
                getBankAccount() != null && getBankAccount().equals(user.getBankAccount()) &&
                getCard() != null && getCard().equals(user.getCard()) &&
                getCredit() != null && getCredit().equals(user.getCredit()) &&
                getContribution() != null && getContribution().equals(user.getContribution()) &&
                getDeposit() != null && getDeposit().equals(user.getDeposit()) &&
                getCurrentId() == user.getCurrentId()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "User{name=\'" + super.getName() + "\', surname=\'" + super.getSurname() +
                "\', number=" + getPhoneNumber() + ", bankAccount=" + getBankAccount() + ", card=" + getCard() +
                ", credit=" + getCredit() + ", contribution=" + getContribution() + ", deposit=" +
                getDeposit() + ", id=" + getCurrentId() + '}';
    }

}
