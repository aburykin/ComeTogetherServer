package ru.bur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bur.domain.db.tables.pojos.AppUser;
import ru.bur.repository.AppUserRepository;

/**
 * Created by Sasha on 26.11.2018.
 */
@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser userAuth(String phoneNumber) {
        AppUser appUser = appUserRepository.findOneByPhoneNumber(phoneNumber);
        if (appUser == null) {
            appUser = new AppUser();
            appUser.setPhoneNumber(phoneNumber);
            appUser.setAuthorizationToken(phoneNumber + "TOKEN");
            appUserRepository.insert(appUser);
        }
        return appUser;
    }

    public AppUser getAppUserByToken(String token) {
        AppUser appUser = appUserRepository.findOneByAuthorizationToken(token);
        return appUser;
    }

}
