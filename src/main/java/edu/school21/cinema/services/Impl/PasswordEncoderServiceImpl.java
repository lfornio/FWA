package edu.school21.cinema.services.Impl;

import edu.school21.cinema.services.PasswordEncoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderServiceImpl implements PasswordEncoderService {

    private BCryptPasswordEncoder encoder;

    @Autowired
    public PasswordEncoderServiceImpl(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public String encode(String password) {
        return encoder.encode(password);
    }

    @Override
    public boolean decode(String passwordInput, String passwordFromDataBase) {
        return encoder.matches(passwordInput, passwordFromDataBase);
    }
}
