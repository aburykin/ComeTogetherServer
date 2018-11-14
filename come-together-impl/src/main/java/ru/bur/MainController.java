package ru.bur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bur.domain.AppUser;
import ru.bur.dto.AppUserDto;
import ru.bur.dto.AuthDto;
import ru.bur.dto.MapperAppUserDto;
import ru.bur.repository.UserRepository;

/**
 * Created by Sasha on 25.10.2018.
 */
@RestController
@RequestMapping("/rest/android")
public class MainController {


    //  тут http://localhost:8080/rest/android
    @PostMapping
    public HttpStatus doSomething(@RequestBody String dto) {
        System.out.println("Get " + dto);
        return HttpStatus.CHECKPOINT;
    }

    @Autowired
    UserRepository userRepository; //dao

   // http://localhost:8080/rest/android/auth

    // TODO
    @PostMapping("/auth")
    public AppUserDto runAuth(@RequestBody AuthDto dto) {
        AppUser appUser;
        if (!dto.getAuthorizationToken().isEmpty()) {
            // проверяю по токену в БД
            appUser = new AppUser();

        }else {
            appUser = new AppUser();
            appUser = userRepository.save(appUser);
        }
        AppUserDto result = MapperAppUserDto.toDto(appUser);
        return result;
    }

}


