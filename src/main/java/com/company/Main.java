package com.company;

import com.company.exceptions.WrongNameOrSurnameException;
import com.company.mainBank.*;
import com.company.people.*;
import com.company.projects.MobileApp;
import com.company.projects.Website;
import com.company.tasks.*;
import com.company.tasks.Currency;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void dash(String str) {
        logger.info("--------------------------------------------------------------------------------------" +
                "----------------------------------------------------");
        logger.info("\t\t\t\t\t\t\t" + str);
        logger.info("---------------------------------------------------------------------------------------" +
                "---------------------------------------------------");
    }

    public LinkedList<User> addUsersToBank() throws WrongNameOrSurnameException, ParseException {

        LinkedList<User> users = new LinkedList<>();

        //*********************************
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 3);

        User user = new User("Artem", "Filippov", "+380995371428", new BankAccount(Currency.FRANCS),
                new Credit(20_000, new Date()), null, null, null);
        user.addCard();
        user.setContribution(new Contribution(35));
        user.setDeposit(new Deposit(0));

        users.add(user);

        //*****************************

        calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 7);

        user = new User("Denys", "Avilov", "+380 44 537 1428", new BankAccount(Currency.HRIVNYA),
                new Credit(90_000, new Date()), null, null, null);
        user.addCard();
        user.setContribution(new Contribution(19));
        user.setDeposit(new Deposit(99_000));

        users.add(user);

        //*****************************


        calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 11);

        user = new User("Maria", "Romanenko", "+380505371428", new BankAccount(Currency.USD),
                null, null, null, null);
        user.addCard();
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

        bankCars.add(new BankCar("Blue", BankCarMarks.MERCEDES, 2002, true, true));
        bankCars.add(new BankCar("Red", BankCarMarks.NISSAN, 2003, true, true));
        bankCars.add(new BankCar("Black", BankCarMarks.VOLKSWAGEN, 2018, false, true));

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

    public void bankInfo(File file) {
        String content = null;
        try {
            content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);

            int index = content.indexOf(" ");
            String word = content.substring(0, index);
            logger.info(StringUtils.countMatches(content, word));

        } catch (IOException e) {
            e.printStackTrace();
        }
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
        dash("DO YOU WANNA TO BE OUR USER? yes OR IF YOU ARE ALREADY OUR USER ENTER \"already\" (IF YOU WANT TO LEAVE JUST SKIP OR ENTER \"exit\")");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        str = str.replaceAll("\\s+", "");

        boolean flag = false;
        boolean flagAlreadyUser = false;
        boolean flagForSomethingWrong = false;

        switch (str) {
            case "exit":
            case "":
                dash("OK GOODBYE");
                break;
            case "already":
                flagAlreadyUser = true;
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
                    user.addBankAccount();
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
                        user.addCard();
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
                            user.addContribution();
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
                                user.addDeposit();
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

        if(flagAlreadyUser) {
            logger.info("Please, enter your ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            boolean present = bank.getUsers().stream().filter(o -> o.getCurrentId() == id).findFirst().isPresent();
            if (present) {
                User user = bank.getUsers().get(id - 1);
                logger.info(user.toString());
            } else {
                logger.info("You are a liar, the user with this ID has not yet been registered!");
            }

            dash("GOODBYE!");

        }

    }

    public static void main(String[] args) throws WrongNameOrSurnameException, ParseException {

        Main main = new Main();
        main.bankInfo(new File("README_BANK.txt"));
        main.run();


    }
}