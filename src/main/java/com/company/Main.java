package com.company;

import com.company.defaultValues.Program;
import com.company.exceptions.WrongNameOrSurnameException;
import java.io.File;
import java.text.ParseException;


public class Main {

    public static void main(String[] args) throws WrongNameOrSurnameException, ParseException {
        Program program = new Program();
        program.bankInfo(new File("README_BANK.txt"));
        program.run();
    }
}