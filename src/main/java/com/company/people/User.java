package com.company.people;

import com.company.exceptions.WrongNameOrSurnameException;
import com.company.tasks.BankAccount;
import com.company.tasks.Card;
import com.company.tasks.Contribution;
import com.company.tasks.Credit;
import com.company.tasks.Deposit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class User extends Human {

    private String phoneNumber;
    private BankAccount bankAccount;
    private Credit credit;
    private Card card;
    private Contribution contribution;
    private Deposit deposit;
    private final Logger logger = LogManager.getLogger(User.class);

    public User() {
    }

    public User(String name, String surname, String phoneNumber, BankAccount bankAccount, Credit credit,
                Card card, Contribution contribution, Deposit deposit) throws WrongNameOrSurnameException {
        super(name, surname);
        this.phoneNumber = phoneNumber;
        this.bankAccount = bankAccount;
        this.credit = credit;
        this.card = card;
        this.contribution = contribution;
        this.deposit = deposit;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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

    @Override
    public int hashCode() {
        int result = super.getName().hashCode() + super.getSurname().hashCode();
        result = result * 31 + getPhoneNumber().hashCode() + getBankAccount().hashCode();
        result = 31 * result + getCard().hashCode() + getCredit().hashCode();
        result = 31 * result + getContribution().hashCode() + getDeposit().hashCode();
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
                getDeposit() != null && getDeposit().equals(user.getDeposit())) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "User Information - Name: " + super.getName() + ", Surname: " + super.getSurname() +
                "number: " + getPhoneNumber() + ", bankAccount: " + getBankAccount() + ", card: " + getCard() +
                ", credit: " + getCredit() + ", contribution: " + getContribution() + ", deposit: " +
                getDeposit();
    }

    @Override
    public void role() {
        logger.debug("This is User");
    }

    @Override
    public void openAccount() {
        logger.debug("I can open an account in Bank! :)");
    }
}
