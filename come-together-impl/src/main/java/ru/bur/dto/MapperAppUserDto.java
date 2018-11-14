package ru.bur.dto;

import ru.bur.domain.AppUser;

public class MapperAppUserDto {

    public static AppUserDto toDto(AppUser appUser) {
        AppUserDto dto = new AppUserDto();
        dto.setUserId(appUser.getUserId());
        dto.setPhoneNumber(appUser.getPhoneNumber());
        dto.setAuthorizationToken(appUser.getAuthorizationToken());
        return dto;
    }

}
