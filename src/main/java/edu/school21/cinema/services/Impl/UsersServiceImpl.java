package edu.school21.cinema.services.Impl;

import edu.school21.cinema.exceptions.AlreadyUserException;
import edu.school21.cinema.exceptions.AppExceptions;
import edu.school21.cinema.exceptions.NoUserOrPasswordErrorException;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UsersRepository;
import edu.school21.cinema.services.PasswordEncoderService;
import edu.school21.cinema.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.Optional;

public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoderService passwordEncoderService;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository,
                            PasswordEncoderService passwordEncoderService) {
        this.usersRepository = usersRepository;
        this.passwordEncoderService = passwordEncoderService;
    }

    @Override
    public void signUp(String email, String firstName, String lastName, String phoneNumber, String password) throws SQLException, AppExceptions {
        User user = new User(email, firstName, lastName, phoneNumber, passwordEncoderService.encode(password));
        if (usersRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new AlreadyUserException();
        }
        usersRepository.save(user);


    }

    @Override
    public void signIn(String email, String password) throws SQLException, AppExceptions {
        Optional<User> optionalUser = usersRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            throw new NoUserOrPasswordErrorException();
        }
        User user = optionalUser.get();
        System.out.println(user);
        System.out.println(password);
        String passwordFromDataBase = user.getPassword();
        boolean isSame = passwordEncoderService.decode(password, passwordFromDataBase);
        System.out.println(isSame);
        if (!isSame) {
            throw new NoUserOrPasswordErrorException();
        }
    }
}
