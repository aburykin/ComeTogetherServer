package ru.bur;

/**
 * Created by Sasha on 25.10.2018.
 */
public class AuthDto {

    String phoneNumber;
    String code;

    public AuthDto(String phoneNumber, String code) {
        this.phoneNumber = phoneNumber;
        this.code = code;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "AuthDto{" +
                "code='" + code + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
