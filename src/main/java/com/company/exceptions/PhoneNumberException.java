package com.company.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PhoneNumberException extends RuntimeException {

    private static final Logger logger = LogManager.getLogger(PhoneNumberException.class);

    public PhoneNumberException() {
        logger.error(this.getStackTrace());
    }

    public PhoneNumberException(String str) {
        super(str);
    }
}
