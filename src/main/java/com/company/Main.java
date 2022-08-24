package com.company;

import com.company.program.Program;
import com.company.exceptions.WrongNameOrSurnameException;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;


public class Main {

    public static void main(String[] args) throws WrongNameOrSurnameException, ParseException {
         Program program = new Program();
         program.bankInfo(new File("README_BANK.txt"));
         program.run();

//        try {
//            Field field = program.getClass().getDeclaredField("field");
//            field.setAccessible(true);
//            System.out.println("Inaccessible field is: '" + (String) field.get(program) + "'");
//
//            Method method = program.getClass().getDeclaredMethod("programMessage", String.class);
//            method.setAccessible(true);
//            method.invoke(program, "hello");
//        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
    }
}