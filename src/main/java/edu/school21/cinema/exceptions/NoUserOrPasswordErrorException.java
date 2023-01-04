package edu.school21.cinema.exceptions;

public class NoUserOrPasswordErrorException extends AppExceptions{

    public NoUserOrPasswordErrorException() {
        super("Проверьте корректность введенных данных");
    }
}
