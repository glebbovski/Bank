package com.company;

import com.company.exceptions.WrongNameOrSurnameException;
import com.company.mainBank.Bank;
import com.company.mainBank.BankCar;
import com.company.people.Driver;
import com.company.people.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws WrongNameOrSurnameException {

        logger.info("Bla-bla-bla");
        Driver driver = new Driver("Gleb", "Chekmezov", 20_000, true);
        Driver driver2 = new Driver("Artem", "Filippov", 15_000, false);
        logger.info(driver.toString());
        logger.info(driver2.toString());

    }
}