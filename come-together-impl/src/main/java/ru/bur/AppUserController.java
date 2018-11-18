package ru.bur;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bur.domain.AppUser;
import ru.bur.dto.AppUserDto;

//@RestController
//@ExposesResourceFor(AppUser.class)
@RequestMapping("/profile/appUsers")
public class AppUserController {

  //  @PostMapping("create-appUsers")
  @RequestMapping("mymethod2")
    public void qew(@RequestBody AppUserDto appUserDto) {
        System.out.println("123");
    }


    @RequestMapping("mymethod")
    public void qe2w(@RequestBody AppUser appUser) {
        System.out.println("123");
    }
}

