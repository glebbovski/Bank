package com.company.interfaces;

import com.company.mainBank.MainSafe;

public interface Lockable {
    boolean lock(MainSafe safe);
}
