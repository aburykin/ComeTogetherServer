package ru.bur;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sasha on 25.10.2018.
 */
@RestController
@RequestMapping("/rest/android")
public class MainController {

    @PostMapping
    public HttpStatus doSomething(@RequestBody String dto){
        // ловит тут http://localhost:8080/rest/android
        System.out.println("Get " + dto);
        return HttpStatus.CHECKPOINT;
    }
}
