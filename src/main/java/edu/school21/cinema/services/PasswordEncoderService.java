package edu.school21.cinema.services;

public interface PasswordEncoderService {

    String encode(String password);
    boolean decode(String passwordInput, String passwordFromDataBase);

}
