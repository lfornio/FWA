package edu.school21.cinema.services.Impl;

import edu.school21.cinema.services.PasswordEncoderService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderServiceImpl implements PasswordEncoderService {
    @Override
    public String encode(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);
        return encoder.encode(password);
    }
}
