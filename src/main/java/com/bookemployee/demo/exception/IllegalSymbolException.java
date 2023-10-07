package com.bookemployee.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Имя и фамилия должны содержать только буквы")
public class IllegalSymbolException extends IllegalArgumentException{
}
