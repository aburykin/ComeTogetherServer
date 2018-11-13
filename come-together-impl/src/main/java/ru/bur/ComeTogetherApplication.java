package ru.bur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Sasha on 25.10.2018.
 */
@SpringBootApplication
public class ComeTogetherApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComeTogetherApplication.class);


        System.out.println("\n\n***********************************************************");
        System.out.println("\n***************  SERVER STARTED  **************************\n");
        System.out.println("***********************************************************\n\n");
    }
}
