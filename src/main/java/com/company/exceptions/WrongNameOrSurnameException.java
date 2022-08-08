package com.company.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WrongNameOrSurnameException extends Exception {

    private static final Logger logger = LogManager.getLogger(WrongNameOrSurnameException.class);

    public WrongNameOrSurnameException() {
        logger.info("!!!!!WrongNameOrSurnameException!!!!!");
    }

    public WrongNameOrSurnameException(String str) {
        super(str);
    }
}
