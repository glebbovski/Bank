package com.company.interfaces;

import com.company.mainBank.Car;
import com.company.people.Driver;

public interface Driveable {
    void drive(Driver driver);
    void needToChange();
}
