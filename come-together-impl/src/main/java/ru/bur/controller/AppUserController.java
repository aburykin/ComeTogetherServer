package ru.bur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bur.dto.AppUserDto;
import ru.bur.dto.AuthDto;
import ru.bur.dto.MapperAppUserDto;
import ru.bur.service.AppUserService;

@RestController
@RequestMapping("/user")
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public AppUserDto userAuth(@RequestBody AuthDto authDto) {
        System.out.println("userAuth() authDto=" + authDto);

        String phoneNumber = authDto.getPhoneNumber();
        if (phoneNumber.isEmpty()) {
            throw new RuntimeException("Не заполнен номер телефона");
        }

        return MapperAppUserDto.toDto(appUserService.userAuth(phoneNumber));
    }
}

