package com.company;

import com.company.exceptions.WrongNameOrSurnameException;
import com.company.mainBank.Bank;
import com.company.mainBank.BankCar;
import com.company.mainBank.IssuePoint;
import com.company.mainBank.MainSafe;
import com.company.people.*;
import com.company.projects.MobileApp;
import com.company.projects.Website;
import com.company.tasks.*;
import com.company.tasks.Currency;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void dash(String str) {
        logger.info("---------------------------------------------------------------------");
        logger.info("\t\t\t\t\t\t\t" + str);
        logger.info("---------------------------------------------------------------------");
    }

    public LinkedList<User> addUsersToBank() throws WrongNameOrSurnameException {

        LinkedList<User> users = new LinkedList<>();

        //*********************************
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 3);

        User user = new User("Artem", "Filippov", "101 555 0125", new BankAccount(Currency.FRANCS),
                new Credit(20_000, new Date()), null, null, null);
        user.setCard(new Card(calendar.getTime()));
        user.setContribution(new Contribution(35));
        user.setDeposit(new Deposit(0));

        users.add(user);

        //*****************************

        calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 7);

        user = new User("Denys", "Avilov", "202 555 0126", new BankAccount(Currency.HRIVNYA),
                new Credit(90_000, new Date()), null, null, null);
        user.setCard(new Card(calendar.getTime()));
        user.setContribution(new Contribution(19));
        user.setDeposit(new Deposit(99_000));

        users.add(user);

        //*****************************


        calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 11);

        user = new User("Maria", "Romaneno", "202 555 0125", new BankAccount(Currency.USD),
                null, null, null, null);
        user.setCard(new Card(calendar.getTime()));
        user.setContribution(new Contribution(19));

        users.add(user);

        //****************************

        // 3 users by default

        return users;
    }


    public ArrayList<Employee> addEmployeesToBank() throws WrongNameOrSurnameException {
        ArrayList<Employee> employees = new ArrayList<>();

        Driver driver = new Driver("Abobus", "Abobusov", 20_000, true);
        employees.add(driver);

        Director director = new Director("Evgeniy", "Alexandrov", 60_000, 20);
        employees.add(director);

        Cashier cashier1 = new Cashier("Briona", "Fagetova", 15_000, 3);
        Cashier cashier2 = new Cashier("Fiona", "Bergeret", 15_000, 2);
        employees.add(cashier1);
        employees.add(cashier2);

        return employees;
    }


    public LinkedList<BankCar> addBankCarsToBank() {
        LinkedList<BankCar> bankCars = new LinkedList<>();

        bankCars.add(new BankCar("Blue", "Toyota", 2002, true, true));
        bankCars.add(new BankCar("Red", "Mazda", 2003, true, true));
        bankCars.add(new BankCar("Black", "Mercedes", 2018, false, true));

        return bankCars;
    }

    public ArrayList<IssuePoint> addIssuePointsToBank() {
        ArrayList<IssuePoint> issuePoints = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 5);

        TreeSet<Date> treeSet = new TreeSet<>();
        treeSet.add(calendar.getTime());
        calendar.add(Calendar.YEAR, 1);
        treeSet.add(calendar.getTime());
        calendar.add(Calendar.MONTH, -2);
        treeSet.add(calendar.getTime());


        issuePoints.add(new IssuePoint("Irpin", treeSet));

        treeSet = new TreeSet<>();
        calendar.add(Calendar.YEAR, 1);
        treeSet.add(calendar.getTime());
        calendar.add(Calendar.MONTH, -1);
        treeSet.add(calendar.getTime());

        issuePoints.add(new IssuePoint("Bucha", treeSet));

        return issuePoints;
    }

    public BankAccount addBankAccount() {
        BankAccount bankAccount = new BankAccount();
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        while (flag) {

            logger.info("Which currency do you want to choose? 1 - EURO, 2 - USD, 3 - HRIVNYA, 4 - FRANCS");
            int cur = Integer.parseInt(scanner.nextLine()); // ADD TRY -------

            switch (cur) {
                case 1:
                    bankAccount.setCurrency(Currency.EURO);
                    flag = false;
                    break;
                case 2:
                    bankAccount.setCurrency(Currency.USD);
                    flag = false;
                    break;
                case 3:
                    bankAccount.setCurrency(Currency.HRIVNYA);
                    flag = false;
                    break;
                case 4:
                    bankAccount.setCurrency(Currency.FRANCS);
                    flag = false;
                    break;
                default:
                    logger.info("Please, change the number!");
                    break;
            }

        }


        return bankAccount;
    }

    public Card addCard() throws ParseException {
        Card card = new Card();
        Scanner scanner = new Scanner(System.in);
        logger.info("Please, enter dateValidity: ");
        String str = scanner.nextLine();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
        card.setValidity(date);
        return card;
    }

    public Contribution addContribution() {
        Contribution contribution = new Contribution();
        logger.info("Please, enter a contributionAmount: ");
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        contribution.setContributionAmount(count);
        return contribution;
    }

    public Deposit addDeposit() {
        Deposit deposit = new Deposit();
        logger.info("Please, enter a depositAmount: ");
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        deposit.setDepositAmount(count);
        return deposit;

    }


    public void run() throws WrongNameOrSurnameException, ParseException {
        dash("Bank Program");
        Bank bank = new Bank();

        bank.setBankName("YOLO Bank");
        dash(bank.getBankName());

        BankOwner bankOwner = new BankOwner("Gleb", "Chekmezov", true);

        bank.setBankOwner(bankOwner);
        bank.setUsers(addUsersToBank());
        bank.setEmployees(addEmployeesToBank());
        bank.setMainSafe(new MainSafe(true, 90_000_000, 100, 200));
        bank.setBankCars(addBankCarsToBank());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -5);

        bank.setWebsite(new Website(calendar.getTime(), 200_000, 9,
                "www.the-best-bank.ua", true));
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("App Store");
        treeSet.add("Play Market");
        treeSet.add(bank.getWebsite().getDomen());

        bank.setMobileApp(new MobileApp(calendar.getTime(), 150_000, 8, true,
                64, treeSet));

        bank.setIssuePoints(addIssuePointsToBank());

        dash("Information About our Bank");
        logger.info(bank.toString());

        dash("START WORKING...");
        dash("DO YOU WANNA TO BE OUR USER? yes or IF YOU WANT TO LEAVE JUST SKIP OR ENTER \"exit\")");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        str = str.replaceAll("\\s+", "");

        boolean flag = false;

        boolean flagForSomethingWrong = false;

        switch (str) {
            case "exit":
            case "":
                dash("OK GOODBYE");
                break;
            case "yes":
                flag = true;
                break;
            default:
                dash("SOMETHING WENT WRONG :/ GOODBYE");
                flagForSomethingWrong = true;
                break;
        }

        if (flag) {
            User user = new User();
            logger.info("Please, enter your name: ");
            str = scanner.nextLine();
            user.setName(str);
            logger.info("Please, enter your surname: ");
            str = scanner.nextLine();
            user.setSurname(str);
            logger.info("Please, enter your phone number: ");
            str = scanner.nextLine();
            user.setPhoneNumber(str);
            logger.info("Do you want to open an bankAccount? yes or no");
            flag = false;
            str = scanner.nextLine();
            switch (str) {
                case "no":
                case "yes":
                    flag = true;
                    break;
                default:
                    dash("SOMETHING WENT WRONG :/ GOODBYE");
                    flagForSomethingWrong = true;
                    break;
            }

            if (flag) {
                if (str.equals("yes")) {
                    user.setBankAccount(addBankAccount());
                }

                logger.info("Do you want to add a card? yes or no");
                flag = false;
                str = scanner.nextLine();

                switch (str) {
                    case "no":
                    case "yes":
                        flag = true;
                        break;
                    default:
                        dash("SOMETHING WENT WRONG :/ GOODBYE");
                        flagForSomethingWrong = true;
                        break;
                }

                if (flag) {
                    if (str.equals("yes")) {
                        user.setCard(addCard());
                    }

                    logger.info("Do you want to add contribution? yes or no");
                    flag = false;
                    str = scanner.nextLine();

                    switch (str) {
                        case "no":
                        case "yes":
                            flag = true;
                            break;
                        default:
                            dash("SOMETHING WENT WRONG :/ GOODBYE");
                            flagForSomethingWrong = true;
                            break;
                    }

                    if (flag) {
                        if (str.equals("yes")) {
                            user.setContribution(addContribution());
                        }

                        logger.info("Do you want to add deposit? yes or no");
                        flag = false;
                        str = scanner.nextLine();

                        switch (str) {
                            case "no":
                            case "yes":
                                flag = true;
                                break;
                            default:
                                dash("SOMETHING WENT WRONG :/ GOODBYE");
                                flagForSomethingWrong = true;
                                break;
                        }
                        if (flag) {
                            if (str.equals("yes")) {
                                user.setDeposit(addDeposit());
                            }


                        }


                    }

                }

            }
            if(!flagForSomethingWrong) {
                bank.addUser(user);
                logger.info(user.toString());
            }
        }



    }

    public static void main(String[] args) throws WrongNameOrSurnameException, ParseException {

        Main main = new Main();
        main.run();

    }
}