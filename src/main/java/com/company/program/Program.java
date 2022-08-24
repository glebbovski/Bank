package com.company.program;

import com.company.Main;
import com.company.exceptions.WrongNameOrSurnameException;
import com.company.interfaces.Functional;
import com.company.mainBank.*;
import com.company.people.*;
import com.company.projects.MobileApp;
import com.company.projects.Website;
import com.company.tasks.*;
import com.company.tasks.Currency;
import com.sun.source.tree.Tree;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

    private final String field = "Private and secret field";

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void dash(String str) {
        logger.info("--------------------------------------------------------------------------------------" +
                "----------------------------------------------------");
        logger.info("\t\t\t\t\t\t\t" + str);
        logger.info("---------------------------------------------------------------------------------------" +
                "---------------------------------------------------");
    }

    public static void dashForAnswer(String... answers) {
        String strMinus = "";
        String topBotStr = "|";
        String centralStr = "|";
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < answers[i].length() + 2; j++) {
                if (j == 0) {
                    centralStr += " ";
                    topBotStr += " ";
                } else if (j > 0 && j < answers[i].length() + 1) {
                    centralStr += answers[i].charAt(j - 1);
                    topBotStr += " ";
                } else {
                    centralStr += " |";
                    topBotStr += " |";
                }
            }
        }
        for (int i = 0; i < topBotStr.length(); i++) {
            strMinus += "-";
        }
        logger.info(strMinus);
        logger.info(topBotStr);
        logger.info(centralStr);
        logger.info(topBotStr);
        logger.info(strMinus);

    }

    private void programMessage(String msg) {
        System.out.println("I am a private method of " + getClass().getSimpleName() + " class. And the message is: " + msg);
    }

    private LinkedList<User> addUsersToBank() throws WrongNameOrSurnameException, ParseException {
        // 3 users by default
        boolean flag = false;
        File file = new File("src/main/resources/files/Users.txt");
        LinkedList<User> users = new LinkedList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 3);
        User user = new User("Artem", "Filippov", "+380995371428", new BankAccount(Currency.FRANCS),
                new Credit(20_000, new Date()), null, null, null);
        user.addCard();
        user.setContribution(new Contribution(35));
        user.setDeposit(new Deposit(0));
        users.add(user);
        if (!file.exists() || file.length() == 0) {
            flag = true;
            insertUserToFile(user, file);
        }
        calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 7);
        user = new User("Denys", "Avilov", "+380445371428", new BankAccount(Currency.HRIVNYA),
                new Credit(90_000, new Date()), null, null, null);
        user.addCard();
        user.setContribution(new Contribution(19));
        user.setDeposit(new Deposit(99_000));
        users.add(user);
        if (flag) {
            insertUserToFile(user, file);
        }

        calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 11);
        user = new User("Maria", "Romanenko", "+380505371428", new BankAccount(Currency.USD),
                null, null, null, null);
        user.addCard();
        user.setContribution(new Contribution(19));
        users.add(user);
        if (flag) {
            insertUserToFile(user, file);
        }

        return users;
    }

    private ArrayList<Employee> addEmployeesToBank() throws WrongNameOrSurnameException {
        ArrayList<Employee> employees = new ArrayList<>();

        boolean flag = false;
        File file = new File("src/main/resources/files/Employees.txt");

        Driver driver = new Driver("Abobus", "Abobusov", "+380914228925", 20_000, true);
        employees.add(driver);
        if (!file.exists() || file.length() == 0) {
            flag = true;
            insertEmployeeToFile(driver, file);
        }

        Director director = new Director("Evgeniy", "Alexandrov","+380925926726" , 60_000, 20);
        employees.add(director);
        if (flag) {
            insertEmployeeToFile(director, file);
        }

        Cashier cashier1 = new Cashier("Briona", "Fagetova", "+380927113254", 15_000, 3);
        Cashier cashier2 = new Cashier("Fiona", "Bergeret", "+380673717845", 15_000, 2);
        employees.add(cashier1);
        employees.add(cashier2);
        if (flag) {
            insertEmployeeToFile(cashier1, file);
            insertEmployeeToFile(cashier2, file);
        }

        return employees;
    }

    private LinkedList<BankCar> addBankCarsToBank() {
        LinkedList<BankCar> bankCars = new LinkedList<>();

        bankCars.add(new BankCar("Blue", BankCarMarks.MERCEDES, 2002, true, true));
        bankCars.add(new BankCar("Red", BankCarMarks.NISSAN, 2003, true, true));
        bankCars.add(new BankCar("Black", BankCarMarks.VOLKSWAGEN, 2018, false, true));

        return bankCars;
    }

    private ArrayList<IssuePoint> addIssuePointsToBank() {

        ArrayList<IssuePoint> issuePoints = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 5);
        Date date1 = calendar.getTime();
        calendar.add(Calendar.YEAR, 1);
        Date date2 = calendar.getTime();
        calendar.add(Calendar.MONTH, -2);
        Date date3 = calendar.getTime();

        TreeSet<Date> treeSet = Stream.of(date1, date2, date3)
                .collect(Collectors.toCollection(() -> new TreeSet<Date>()));

        issuePoints.add(new IssuePoint("Irpin", treeSet));

        calendar.add(Calendar.YEAR, 1);
        date1 = calendar.getTime();
        calendar.add(Calendar.MONTH, -1);
        date2 = calendar.getTime();
        treeSet = Stream.of(date1, date2)
                .collect(Collectors.toCollection(() -> new TreeSet<Date>()));

        issuePoints.add(new IssuePoint("Bucha", treeSet));
        return issuePoints;
    }

    public void bankInfo(File file) {
        String content = null;
        try {
            content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);

            int index = content.indexOf(" ");
            String word = content.substring(0, index);
            logger.info("Word: " + word + ", Amount: " + StringUtils.countMatches(content, word));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private User creatingAnUser() throws WrongNameOrSurnameException, ParseException {
        User user = new User();
        boolean switchChoiceDoneCorrectly = false;
        String tmp = null;
        Scanner scanner = new Scanner(System.in);
        logger.info("Please, enter your name: ");
        tmp = scanner.nextLine().replaceAll("\\s+", "");
        user.setName(tmp);
        logger.info("Please, enter your surname: ");
        tmp = scanner.nextLine().replaceAll("\\s+", "");
        user.setSurname(tmp);
        logger.info("Please, enter your phone number: ");
        tmp = scanner.nextLine().replaceAll("\\s+", "");
        user.setPhoneNumber(tmp);

        if (isAlredyAdded(user.getName(), user.getSurname(), user.getPhoneNumber())) {
            return null;
        }

        boolean flagYesChoice = false;
        boolean flagNoChoice = false;

        while (!switchChoiceDoneCorrectly) {
            logger.info("Do you want to open an bankAccount?");
            dashForAnswer("yes", "no");
            tmp = scanner.nextLine().replaceAll("\\s+", "");
            switch (tmp) {
                case "yes":
                    flagYesChoice = true;
                    switchChoiceDoneCorrectly = true;
                    break;
                case "no":
                    flagNoChoice = true;
                    switchChoiceDoneCorrectly = true;
                    break;
                default:
                    dash("Something went wrong, try again");
                    break;
            }
        }

        if (flagYesChoice) {
            user.addBankAccount();
        }

        switchChoiceDoneCorrectly = false;
        flagYesChoice = false;

        while (!switchChoiceDoneCorrectly) {
            logger.info("Do you want to open a credit?");
            dashForAnswer("yes", "no");
            tmp = scanner.nextLine().replaceAll("\\s+", "");
            switch (tmp) {
                case "yes":
                    flagYesChoice = true;
                    switchChoiceDoneCorrectly = true;
                    break;
                case "no":
                    flagNoChoice = true;
                    switchChoiceDoneCorrectly = true;
                    break;
                default:
                    dash("Something went wrong, try again");
                    break;
            }
        }

        if (flagYesChoice) {
            user.addCredit();
        }

        switchChoiceDoneCorrectly = false;
        flagYesChoice = false;

        while (!switchChoiceDoneCorrectly) {
            logger.info("Do you want to add a card?");
            dashForAnswer("yes", "no");
            tmp = scanner.nextLine().replaceAll("\\s+", "");
            switch (tmp) {
                case "yes":
                    flagYesChoice = true;
                    switchChoiceDoneCorrectly = true;
                    break;
                case "no":
                    flagNoChoice = true;
                    switchChoiceDoneCorrectly = true;
                    break;
                default:
                    dash("Something went wrong, try again");
                    break;
            }
        }

        if (flagYesChoice) {
            user.addCard();
        }

        switchChoiceDoneCorrectly = false;
        flagYesChoice = false;

        while (!switchChoiceDoneCorrectly) {
            logger.info("Do you want to add a contribution?");
            dashForAnswer("yes", "no");
            tmp = scanner.nextLine().replaceAll("\\s+", "");
            switch (tmp) {
                case "yes":
                    flagYesChoice = true;
                    switchChoiceDoneCorrectly = true;
                    break;
                case "no":
                    flagNoChoice = true;
                    switchChoiceDoneCorrectly = true;
                    break;
                default:
                    dash("Something went wrong, try again");
                    break;
            }
        }

        if (flagYesChoice) {
            user.addContribution();
        }

        switchChoiceDoneCorrectly = false;
        flagYesChoice = false;

        while (!switchChoiceDoneCorrectly) {
            logger.info("Do you want to add a deposit?");
            dashForAnswer("yes", "no");
            tmp = scanner.nextLine().replaceAll("\\s+", "");
            switch (tmp) {
                case "yes":
                    flagYesChoice = true;
                    switchChoiceDoneCorrectly = true;
                    break;
                case "no":
                    flagNoChoice = true;
                    switchChoiceDoneCorrectly = true;
                    break;
                default:
                    dash("Something went wrong, try again");
                    break;
            }
        }

        if (flagYesChoice) {
            user.addDeposit();
        }

        return user;
    }

    private void insertUserToFile(User user, File file) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(user.toString() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void insertEmployeeToFile(Employee employee, File file) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(employee.toString() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertOwnerToFile(BankOwner owner, File file) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(owner.toString() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Bank bankInitialization() throws WrongNameOrSurnameException, ParseException {
        Bank bank = new Bank();
        bank.setBankName("YOLO Bank");
        File file = new File("src/main/resources/files/Owners.txt");
        BankOwner bankOwner = new BankOwner("Gleb", "Chekmezov", "+380991109744", true);
        if (!file.exists() || file.length() == 0) {
            insertOwnerToFile(bankOwner, file);
        }
        bank.setBankOwner(bankOwner);
        bank.setUsers(addUsersToBank());
        bank.setEmployees(addEmployeesToBank());
        bank.setMainSafe(new MainSafe(true, 90_000_000, 100, 200));
        bank.setBankCars(addBankCarsToBank());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -5);

        bank.setWebsite(new Website(calendar.getTime(), 200_000, 9,
                "www.the-best-bank.ua", true));
        // Stream usage
        TreeSet<String> treeSet = Stream.of("App Store", "Play Market", bank.getWebsite().getDomen())
                .map(x -> x.toUpperCase()).collect(Collectors.toCollection(() -> new TreeSet<String>()));
        bank.setMobileApp(new MobileApp(calendar.getTime(), 150_000, 8, true,
                64, treeSet));
        bank.setIssuePoints(addIssuePointsToBank());

        return bank;
    }

    private boolean findHumanInString(String tmp, String name, String surname, String phoneNumber) {
        int idxName = tmp.indexOf("name");
        int idxSurname = tmp.indexOf("surname");
        int idxPhone = tmp.indexOf("phoneNumber");
        int idxGalo4kaOne = tmp.indexOf('\'', idxName);
        int idxGalo4kaTwo = tmp.indexOf('\'', idxGalo4kaOne + 1);
        String tmpName = tmp.substring(idxGalo4kaOne + 1, idxGalo4kaTwo);
        idxGalo4kaOne = tmp.indexOf('\'', idxSurname);
        idxGalo4kaTwo = tmp.indexOf('\'', idxGalo4kaOne + 1);
        String tmpSurname = tmp.substring(idxGalo4kaOne + 1, idxGalo4kaTwo);
        idxGalo4kaOne = tmp.indexOf('\'', idxPhone);
        idxGalo4kaTwo = tmp.indexOf('\'', idxGalo4kaOne + 1);
        String tmpPhone = tmp.substring(idxGalo4kaOne + 1, idxGalo4kaTwo);
        tmpPhone = tmpPhone.replaceAll("\\s+", "");
        if(tmpPhone.equals(phoneNumber)) {
            return true;
        } else {
            return false;
        }
//        if (tmpSurname.equals(surname) && tmpName.equals(name) && tmpPhone.equals(phoneNumber)) {
//            return true;
//        } else {
//            return false;
//        }
    }

    private boolean isAlredyAdded(String... items) {
        String name;
        String surname;
        String phoneNumber;
        Scanner scanner = new Scanner(System.in);
        boolean findSomeone = false;
        if (items == null || items.length == 0) {
            logger.info("Please, enter your name: ");
            name = scanner.nextLine().replaceAll("\\s+", "");
            logger.info("Please, enter your surname: ");
            surname = scanner.nextLine().replaceAll("\\s+", "");
            logger.info("Please, enter your phone number: ");
            phoneNumber = scanner.nextLine();
        } else {
            name = items[0];
            surname = items[1];
            phoneNumber = items[2];
        }
        boolean presentUserID = true;
        boolean presentEmployeeID = true;
        boolean presentUser = true;
        boolean presentEmployee = true;

        List<String> lines = new ArrayList<>();

        try (Stream<String> lineStream = Files.newBufferedReader(
                        Paths.get("src/main/resources/files/Users.txt"))
                .lines()) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (presentUserID) {
            String tmp = null;
            boolean found = false;
            for(int i = 0; i < lines.size(); i++) {
                tmp = lines.get(i);
                found = findHumanInString(tmp, name, surname, phoneNumber);
                if (found) {
                    break;
                }
            }
            if (found) {
                presentUser = true;
                dash("We found you as our User!");
                findSomeone = true;
                logger.info(tmp);
                dash("Sorry, you can not do something with your account because we have some technical troubles. Try later :(");
            } else {
                presentUser = false;
            }
        }

        if (!presentUser) {
            try (Stream<String> lineStream = Files.newBufferedReader(
                            Paths.get("src/main/resources/files/Employees.txt"))
                    .lines()) {
                lines = lineStream.collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }


            if (presentEmployeeID) {
                String tmp = null;
                boolean found = false;
                for(int i = 0; i < lines.size(); i++) {
                    tmp = lines.get(i);
                    found = findHumanInString(tmp, name, surname, phoneNumber);
                    if (found) {
                        break;
                    }
                }
                if (found) {
                    presentEmployee = true;
                    dash("We found you as our Employee!");
                    findSomeone = true;
                    logger.info(tmp);
                    dash("Sorry, you can not do something with your account because you are our employee! Have a good day! ;)");
                } else {
                    presentEmployee = false;
                }
            }
        }
        return findSomeone;
    }

    private void workAfterInit(User user, Bank bank) {
        Scanner scanner = new Scanner(System.in);
        boolean switchCorrectlyChosen = false;
        int choice = -1;
        while (!switchCorrectlyChosen) {
            dash("If you want to change current not null information, you need to go to the Issue Point: " + bank.getIssuePoints().toString());
            dash("Your username is : " + user.getName());
            dash("Do you want to work with ...");
            dashForAnswer("My Bank Account (account)", "My Cards (cards)",
                    "My Contribution (contribution)", "My Credit (credit)", "My Deposit (deposit)", "Exit");
            String tmp = scanner.nextLine();
            switch (tmp) {
                case "account":
                    choice = 1;
                    switchCorrectlyChosen = true;
                    break;
                case "cards":
                    choice = 2;
                    switchCorrectlyChosen = true;
                    break;
                case "contribution":
                    choice = 3;
                    switchCorrectlyChosen = true;
                    break;
                case "credit":
                    choice = 4;
                    switchCorrectlyChosen = true;
                    break;
                case "deposit":
                    choice = 5;
                    switchCorrectlyChosen = true;
                    break;
                case "Exit":
                    choice = 6;
                    switchCorrectlyChosen = true;
                    break;
                default:
                    dash("Try again :/");
                    choice = -1;
            }

            if (choice == 6) {
              // dash("Ok, goodbye");
            }

            if (choice == 1) {
                if (user.getBankAccount() == null) {
                    dash("You do not have bank account! Do you want to create it?");
                    dashForAnswer("yes", "no or any other characters to go back");
                    tmp = scanner.nextLine().replaceAll("\\s+", "");
                    switch (tmp) {
                        case "yes":
                            user.addBankAccount();
                            dash(user.getBankAccount().toString());
                            switchCorrectlyChosen = false;
                            break;
                        default:
                            switchCorrectlyChosen = false;
                    }
                } else {
                    dash("You have bank account already!");
                    dash("Getting information...");
                    dash(user.getBankAccount().toString());
                    switchCorrectlyChosen = false;

                }
            }

            if (choice == 2) {
                if (user.getCards() == null || user.getCards().size() == 0) {
                    dash("You do not have any cards. Do you want to add the card?");
                    dashForAnswer("yes", "no or any other characters to go back");
                    tmp = scanner.nextLine().replaceAll("\\s+", "");
                    switch (tmp) {
                        case "yes":
                            try {
                                user.addCard();
                                dash(user.getCards().toString());
                                switchCorrectlyChosen = false;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        default:
                            switchCorrectlyChosen = false;
                    }
                } else {
                    dash("You have some cards. Wait a second...");
                    dash(user.getCards().toString());
                    dash("Do you want to add another one?");
                    dashForAnswer("yes", "no or any other characters to go back");
                    tmp = scanner.nextLine().replaceAll("\\s+", "");
                    switch (tmp) {
                        case "yes":
                            try {
                                user.addCard();
                                dash(user.getCards().toString());
                                switchCorrectlyChosen = false;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        default:
                            switchCorrectlyChosen = false;
                    }
                }
            }

            if (choice == 3) {
                if (user.getContribution() == null) {
                    dash("You do not have a contribution. Do you want to add it?");
                    dashForAnswer("yes", "no or any other characters to go back");
                    tmp = scanner.nextLine().replaceAll("\\s+", "");
                    switch (tmp) {
                        case "yes":
                            try {
                                user.addContribution();
                                dash(user.getContribution().toString());
                                switchCorrectlyChosen = false;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        default:
                            switchCorrectlyChosen = false;
                    }
                } else {
                    dash("You have contribution already!");
                    dash("Getting information...");
                    dash(user.getContribution().toString());
                    switchCorrectlyChosen = false;
                }
            }

            if (choice == 4) {
                if (user.getCredit() == null) {
                    dash("You do not have a credit. Do you want to add it?");
                    dashForAnswer("yes", "no or any other characters to go back");
                    tmp = scanner.nextLine().replaceAll("\\s+", "");
                    switch (tmp) {
                        case "yes":
                            try {
                                user.addCredit();
                                dash(user.getCredit().toString());
                                switchCorrectlyChosen = false;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        default:
                            switchCorrectlyChosen = false;
                    }
                } else {
                    dash("You have credit already!");
                    dash("Getting information...");
                    dash(user.getCredit().toString());
                    switchCorrectlyChosen = false;
                }
            }

            if (choice == 5) {
                if (user.getDeposit() == null) {
                    dash("You do not have a deposit. Do you want to add it?");
                    dashForAnswer("yes", "no or any other characters to go back");
                    tmp = scanner.nextLine().replaceAll("\\s+", "");
                    switch (tmp) {
                        case "yes":
                            try {
                                user.addDeposit();
                                dash(user.getDeposit().toString());
                                switchCorrectlyChosen = false;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        default:
                            switchCorrectlyChosen = false;
                    }
                } else {
                    dash("You have deposit already!");
                    dash("Getting information...");
                    dash(user.getDeposit().toString());
                    switchCorrectlyChosen = false;
                }
            }
        }

    }

    public void run() throws WrongNameOrSurnameException, ParseException {

        Bank bank = bankInitialization();
        dash("Bank Program");
        dash(bank.getBankName());
        dash("Start working...");

        boolean flagYesChoice = false;
        boolean flagNoChoice = false;
        boolean flagExitChoice = false;
        boolean flagForSomethingWrong = false;
        boolean switchChoiceDoneCorrectly = false;

        Scanner scanner = new Scanner(System.in);
        String str = null;

        while (!switchChoiceDoneCorrectly) {
            dash("Hello! Have you already been in YOLO bank?");
            dashForAnswer("yes", "no", "exit");
            str = scanner.nextLine().replaceAll("\\s+", "");
            switch (str) {
                case "exit":
                    flagExitChoice = true;
                    switchChoiceDoneCorrectly = true;
                    break;
                case "yes":
                    flagYesChoice = true;
                    switchChoiceDoneCorrectly = true;
                    break;
                case "no":
                    flagNoChoice = true;
                    switchChoiceDoneCorrectly = true;
                    break;
                default:
                    dash("Something went wrong, try again");
                    break;
            }
        }

        if(flagYesChoice) {
            if (!isAlredyAdded()) {
                switchChoiceDoneCorrectly = false;
                flagExitChoice = false;
                flagYesChoice = false;
                while (!switchChoiceDoneCorrectly) {
                    dash("We couldn't find you! Do you want to register as new User? " +
                            "(Sorry, we do not need new Employees now)");
                    dashForAnswer("yes", "no");
                    str = scanner.nextLine().replaceAll("\\s+", "");
                    switch (str) {
                        case "yes":
                            flagYesChoice = true;
                            switchChoiceDoneCorrectly = true;
                            break;
                        case "no":
                            flagExitChoice = true;
                            switchChoiceDoneCorrectly = true;
                            break;
                        default:
                            dash("Something went wrong, try again");
                            break;
                    }
                }

                if (flagYesChoice) {
                    User user = creatingAnUser();
                    if (user == null) {
                        dash("We found a person with this personal information in our list. Please, " +
                                "don't pretend to be someone else!");
                    } else {
                        flagExitChoice = true;
                        if (user.getCurrentId() == 100) {
                            dash("You are our " + user.getCurrentId() + "th user, so we decided to do you our Owner!!!");
                            BankOwner owner = User.converter.convert(user);
                            insertOwnerToFile(owner, new File("src/main/resources/files/Owners.txt"));
                            dash(owner.toString());
                        } else {
                            dash("We added you to list of user");
                            workAfterInit(user, bank);
                            insertUserToFile(user, new File("src/main/resources/files/Users.txt"));
                            bank.addUser(user);
                        }
                    }

                }

            }

        }
        // has not been ----
        if (flagNoChoice) {
            switchChoiceDoneCorrectly = false;
            while (!switchChoiceDoneCorrectly) {
                dash("Do you want to register as new User? " +
                        "(Sorry, we do not need new Employees now)");
                dashForAnswer("yes", "no");
                str = scanner.nextLine().replaceAll("\\s+", "");
                switch (str) {
                    case "yes":
                        flagYesChoice = true;
                        switchChoiceDoneCorrectly = true;
                        break;
                    case "no":
                        flagExitChoice = true;
                        switchChoiceDoneCorrectly = true;
                        break;
                    default:
                        dash("Something went wrong, try again");
                        break;
                }
            }
            if (flagYesChoice) {
                    User user = creatingAnUser();
                    if (user == null) {
                        dash("We found a person with this personal information in our list. Please, " +
                                "don't pretend to be someone else!");
                    } else {
                        flagExitChoice = true;
                        if (user.getCurrentId() == 100) {
                            dash("You are our " + user.getCurrentId() + "th user, so we decided to do you our Owner!!!");
                            BankOwner owner = User.converter.convert(user);
                            insertOwnerToFile(owner, new File("src/main/resources/files/Owners.txt"));
                            dash(owner.toString());
                        } else {
                            dash("We added you to list of user");
                            // dash(user.toString());
                            workAfterInit(user, bank);
                            insertUserToFile(user, new File("src/main/resources/files/Users.txt"));
                            bank.addUser(user);
                        }
                    }
            }

        }

        if (flagExitChoice) {
            dash("Ok, goodbye!");
        }


    }
}
