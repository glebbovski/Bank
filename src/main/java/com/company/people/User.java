package com.company.people;

import com.company.exceptions.PhoneNumberException;
import com.company.exceptions.WrongNameOrSurnameException;
import com.company.interfaces.Functional;
import com.company.interfaces.Openable;
import com.company.tasks.*;
import com.company.tasks.Currency;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import  com.company.tasks.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User extends Human implements Openable {
    public static int id = 0;
    private final int currentId;
    private BankAccount bankAccount;
    private Credit credit;
    private ArrayList<Card> cards = new ArrayList<>();
    private Contribution contribution;
    private Deposit deposit;
    private final Logger logger = LogManager.getLogger(User.class);

    {
        List<String> lines = new ArrayList<>();
        try (Stream<String> lineStream = Files.newBufferedReader(
                        Paths.get("src/main/resources/files/Users.txt"))
                .lines()) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        User.id = lines.size() + 1;
        this.currentId = User.id;
    }

    public User() {
    }

    public User(String name, String surname, String phoneNumber, BankAccount bankAccount, Credit credit,
                Card card, Contribution contribution, Deposit deposit) throws WrongNameOrSurnameException {
        super(name, surname, phoneNumber);
        this.bankAccount = bankAccount;
        this.credit = credit;
        if (card != null) {
            this.cards.add(card);
        }
        this.contribution = contribution;
        this.deposit = deposit;
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

    public static Functional<User, BankOwner> converter = x -> new BankOwner(x.getName(), x.getSurname(), x.getPhoneNumber(), true);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return currentId == user.currentId && Objects.equals(bankAccount, user.bankAccount) && Objects.equals(credit, user.credit) && Objects.equals(cards, user.cards) && Objects.equals(contribution, user.contribution) && Objects.equals(deposit, user.deposit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentId, bankAccount, credit, cards, contribution, deposit);
    }

    @Override
    public String toString() {
        return "User{" + "name='" + getName() + "', surname='" + getSurname() + "', phoneNumber='"
                + getPhoneNumber() + "'" +
                ", currentId=" + currentId +
                ", bankAccount=" + bankAccount +
                ", credit=" + credit +
                ", cards=" + cards +
                ", contribution=" + contribution +
                ", deposit=" + deposit +
                '}';
    }
}
