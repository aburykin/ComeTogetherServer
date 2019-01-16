package ru.bur.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Номер телефона не заполнен")
public class PhoneNumberIsEmptyException extends RuntimeException {

}
