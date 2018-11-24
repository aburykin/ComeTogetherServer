package ru.bur.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bur.domain.AppUser;

/**
 * Created by Sasha on 24.11.2018.
 */
@RepositoryRestController
public class OverrideHateOasController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/appUsers/create-appUsers")  //(Constants.PROJECTSPATH) // @PostMapping is a shortcut for @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addProject(@RequestBody AppUser appUser) {
/*
        final URI uri =MvcUriComponentsBuilder.fromController(getClass())
                        .path("/{id}")
                        .buildAndExpand(project.getId())
                        .toUri();*/


      //  return ResponseEntity.created(uri).body(new ProjectResource(project));

        System.out.println("Приел запрос appUser="+appUser);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


}