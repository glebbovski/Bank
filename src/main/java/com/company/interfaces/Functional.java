package com.company.interfaces;

import com.company.exceptions.WrongNameOrSurnameException;

public interface Functional<T, N> {
    N convert(T t) throws WrongNameOrSurnameException;
}
