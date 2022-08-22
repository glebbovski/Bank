package com.company.people;

import com.company.exceptions.PhoneNumberException;
import com.company.exceptions.WrongNameOrSurnameException;
import com.company.interfaces.Functional;
import com.company.interfaces.Openable;
import com.company.tasks.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import  com.company.tasks.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User extends Human implements Openable {
    private static int id = 0;
    private final int currentId;
    private String phoneNumber;
    private BankAccount bankAccount;
    private Credit credit;
    private ArrayList<Card> cards = new ArrayList<>();
    private Contribution contribution;
    private Deposit deposit;
    private final Logger logger = LogManager.getLogger(User.class);

    {
        User.id++;
        this.currentId = User.id;
    }

    public User() {
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
        if (card != null) {
            this.cards.add(card);
        }
        this.contribution = contribution;
        this.deposit = deposit;
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

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
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
    public void addBankAccount() {
        if (this.bankAccount != null) {
            logger.info("You have an account already!");
            return;
        }
        this.bankAccount = new BankAccount();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {

            logger.info("Which currency do you want to choose? 1 - EURO, 2 - USD, 3 - HRIVNYA, 4 - FRANCS");
            int cur = Integer.parseInt(scanner.nextLine()); // ADD TRY -------

            switch (cur) {
                case 1:
                    this.bankAccount.setCurrency(Currency.EURO);
                    flag = false;
                    break;
                case 2:
                    this.bankAccount.setCurrency(Currency.USD);
                    flag = false;
                    break;
                case 3:
                    this.bankAccount.setCurrency(Currency.HRIVNYA);
                    flag = false;
                    break;
                case 4:
                    this.bankAccount.setCurrency(Currency.FRANCS);
                    flag = false;
                    break;
                default:
                    logger.info("Please, change the number!");
                    break;
            }

        }

    }

    @Override
    public void addDeposit() {
        if (this.deposit != null) {
            logger.info("You have a deposit already!");
            return;
        }
        this.deposit = new Deposit();
        logger.info("Please, enter a depositAmount: ");
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        this.deposit.setDepositAmount(count);
    }

    @Override
    public void addCredit() {
        logger.info("You can open credit in Bank if you did not do this before and if you did not exceed the limit! :)");
        if (this.credit != null) {
            logger.info("You have a credit in our bank already!");
        }
        this.credit = new Credit();
        Scanner scanner = new Scanner(System.in);
        logger.info("Please, enter a needed sum for your credit: ");
        int sum = Integer.parseInt(scanner.nextLine());
        this.credit.setCurrentCredit(sum);
        this.credit.setLastPaymentDate(new Date());

    }

    @Override
    public void addCard() throws ParseException {
        Card card = new Card();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 3); // card for 3 years
        card.setValidity(calendar.getTime());
        card.setName(this.getName());
        card.setSurname(this.getSurname());
        this.cards.add(card);
    }

    @Override
    public void addContribution() {
        if (this.contribution != null) {
            logger.info("You have a contribution already!");
            return;
        }
        this.contribution = new Contribution();
        logger.info("Please, enter a contributionAmount: ");
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        this.contribution.setContributionAmount(count);
    }

    public static Functional<User, BankOwner> converter = x -> new BankOwner(x.getName(), x.getSurname(), true);

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
        result = 31 * result + getCards().hashCode() + getCredit().hashCode();
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
                getCards() != null && getCards().equals(user.getCards()) &&
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
                "\', number=" + getPhoneNumber() + ", bankAccount=" + getBankAccount() + ", cards=" + getCards() +
                ", credit=" + getCredit() + ", contribution=" + getContribution() + ", deposit=" +
                getDeposit() + ", id=" + getCurrentId() + '}';
    }

}
