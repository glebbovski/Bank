package com.company.exceptions;

import com.company.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreditLimitException extends RuntimeException {

    private static final Logger logger = LogManager.getLogger(CreditLimitException.class);

    public CreditLimitException() {
        logger.error(this.getStackTrace());
    }

    public CreditLimitException(String str) {
        super(str);
    }
}
