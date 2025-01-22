package com.example.spring_security_2.entities;

public class LoginResponseDto {
    private ApplicationUser user;
    private String jwt;

    public LoginResponseDto() {
        super();
    }

    public LoginResponseDto(ApplicationUser user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
