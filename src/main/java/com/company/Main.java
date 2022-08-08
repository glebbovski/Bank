package com.company;

import com.company.exceptions.WrongNameOrSurnameException;
import com.company.mainBank.BankCar;
import com.company.people.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws WrongNameOrSurnameException {

        logger.debug("Bla-bla-bla");
        logger.trace("We've just greeted the user!");
        logger.debug("We've just greeted the user!");
        logger.info("We've just greeted the user!");
        logger.warn("We've just greeted the user!");
        logger.error("We've just greeted the user!");
        logger.fatal("We've just greeted the user!");
    }
}