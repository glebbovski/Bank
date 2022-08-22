package com.company.interfaces;

import com.company.exceptions.WrongNameOrSurnameException;
@FunctionalInterface
public interface Functional<T, N> {
    N convert(T t) throws WrongNameOrSurnameException;
}
