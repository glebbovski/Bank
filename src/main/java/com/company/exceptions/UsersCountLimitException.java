package com.company.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsersCountLimitException extends RuntimeException {

    private static final Logger logger = LogManager.getLogger(UsersCountLimitException.class);

    public UsersCountLimitException() {
        logger.info("!!!!!UsersCountLimitException!!!!!!");
    }

    public UsersCountLimitException(String str) {
        super(str);
    }
}
