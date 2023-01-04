package edu.school21.cinema.exceptions;

public class AlreadyUserException extends AppExceptions{

    public AlreadyUserException() {
        super("Пользователь с таким email уже зарегистрирован");
    }
}
