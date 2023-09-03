package com.bookemployee.demo.util;

import com.bookemployee.demo.exception.IllegalSymbolException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class EmployeeNameValidator {
    public static void validateIsAlpha(String... names) {
        for (String name : names) {
            if (!StringUtils.isAlpha(name)) {
                throw new IllegalSymbolException();
            }
        }
    }
}


