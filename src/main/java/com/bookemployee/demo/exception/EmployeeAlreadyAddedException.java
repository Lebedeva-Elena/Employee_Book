package com.bookemployee.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Такой сотрудник уже есть")
public class EmployeeAlreadyAddedException extends RuntimeException {
}
