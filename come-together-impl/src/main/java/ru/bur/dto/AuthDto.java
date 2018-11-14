package ru.bur.dto;

import lombok.Data;

@Data
public class AuthDto {

    private String phoneNumber;

    private String authorizationToken;
}
