package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import java.sql.SQLException;

public interface UsersService {
    void signUp(String email, String firstName, String lastName, String phoneNumber, String password) throws SQLException;
    User signIn(String email, String password) throws SQLException;
}
