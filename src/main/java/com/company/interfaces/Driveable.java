package com.company.interfaces;

import com.company.people.Driver;

public interface Driveable {
    void drive(Driver driver);

    void drift(Driver driver, int meters);
}
