package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void signUp(String email, String firstName, String lastName, String phoneNumber, String password) {
        System.out.println("метод signUp");
        User user = new User(email, firstName, lastName,phoneNumber,password);
        try {
            usersRepository.save(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void signIn() {

    }
}
