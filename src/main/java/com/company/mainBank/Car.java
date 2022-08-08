package com.company.mainBank;

import com.company.Main;
import com.company.interfaces.Driveable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Car implements Driveable {
    private String color;
    private String mark;
    private final Logger logger = LogManager.getLogger(Car.class);


    public Car() {

    }

    public Car(String color, String mark) {
        this.color = color;
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void sound() {
        logger.debug("beep-beep");
    }

    public abstract void style();
}
