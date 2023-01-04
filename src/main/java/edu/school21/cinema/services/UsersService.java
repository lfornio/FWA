package edu.school21.cinema.services;

import javax.management.MXBean;
import java.sql.SQLException;

public interface UsersService {
    void signUp(String email, String firstName, String lastName, String phoneNumber, String password) throws SQLException;
    void signIn();




}
