package ru.bur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bur.domain.AppUser;
import ru.bur.repository.UserRepository;

/**
 * Created by Sasha on 26.11.2018.
 */
@Service
public class AppUserService {

    @Autowired
    private UserRepository userRepository;

    public AppUser userAuth(String phoneNumber) {
        AppUser appUser = userRepository.findByPhoneNumber(phoneNumber);
        if (appUser == null) {
            // создаем в базе нового польвателя и присваиваем ем token
            appUser = new AppUser();
            appUser.setPhoneNumber(phoneNumber);
            appUser.setAuthorizationToken(phoneNumber + "TOKEN");
            appUser = userRepository.save(appUser);
        }
        return appUser;
    }
}
