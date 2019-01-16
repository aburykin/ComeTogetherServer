package ru.bur.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bur.controller.exception.PhoneNumberIsEmptyException;
import ru.bur.dto.AppUserDto;
import ru.bur.dto.AuthDto;
import ru.bur.dto.MapperAppUserDto;
import ru.bur.service.AppUserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final static Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AppUserService appUserService;

    @PostMapping
    public AppUserDto userAuth(@RequestBody AuthDto authDto) {
        log.info(String.format("userAuth() authDto=%s", authDto));
        String phoneNumber = authDto.getPhoneNumber();
        if (phoneNumber.isEmpty()) {
            throw new PhoneNumberIsEmptyException();
        }
        AppUserDto responce = MapperAppUserDto.toDto(appUserService.userAuth(phoneNumber));
        log.info("responce=" + responce);
        return responce;
    }
}

