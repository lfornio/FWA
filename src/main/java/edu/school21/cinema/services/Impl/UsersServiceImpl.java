package edu.school21.cinema.services.Impl;

import edu.school21.cinema.exceptions.AlreadyUserException;
import edu.school21.cinema.exceptions.AppExceptions;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UsersRepository;
import edu.school21.cinema.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void signUp(String email, String firstName, String lastName, String phoneNumber, String password) throws SQLException, AppExceptions {
        User user = new User(email, firstName, lastName, phoneNumber, password);
        if (usersRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new AlreadyUserException("Пользователь с таким email же зарегистрирован");
        }
        usersRepository.save(user);


    }

    @Override
    public void signIn() {

    }
}
