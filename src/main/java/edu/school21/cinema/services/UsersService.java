package edu.school21.cinema.services;

import javax.management.MXBean;

public interface UsersService {
    void signUp(String email, String firstName, String lastName, String phoneNumber, String password);
    void signIn();




}
