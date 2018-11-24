package ru.bur;

import com.sun.net.httpserver.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bur.dto.AppUserDto;
import ru.bur.repository.UserRepository;

/**
 * Created by Sasha on 25.10.2018.
 */
@RestController
@RequestMapping("/rest/android")
public class MainController {

    @PostMapping("/test_post_with_headers")
    public AppUserDto test_post_with_headers(@RequestHeader(name = "Content-Type") String contentType, @RequestBody AppUserDto dto) {
        System.out.println("Get " + dto);
        AppUserDto appUserDto = dto;
        dto.setUserId(10L);
        return appUserDto;
    }


    @PostMapping("/test_get_dto_return_dto")
    public AppUserDto test_get_dto_return_dto(@RequestBody AppUserDto dto) {
        System.out.println("Get " + dto);
        AppUserDto appUserDto = dto;
        dto.setUserId(10L);
        return appUserDto;
    }

    @PostMapping("/test_get_dto_return_dto_with_error")
    public AppUserDto test_get_dto_return_dto_with_error(@RequestBody AppUserDto dto) {
        System.out.println("Get " + dto);
        AppUserDto appUserDto = dto;
        dto.setUserId(10L);
        if (1 == 1) throw new RuntimeException("Некая ошибка");
        return appUserDto;
    }

    @PostMapping("/with_response_entity")
    public ResponseEntity<AppUserDto> with_response_entity(@RequestBody AppUserDto dto) {
        System.out.println("Get " + dto);
        dto.setUserId(10L);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }


    //  тут http://localhost:8080/rest/android
    @PostMapping
    public HttpStatus doSomething(@RequestBody String dto) {
        System.out.println("Get " + dto);
        return HttpStatus.CHECKPOINT;
    }

    @Autowired
    UserRepository userRepository; //dao

    // http://localhost:8080/rest/android/auth
/*
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
*/
}


