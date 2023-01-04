package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.CrudRepository;

import java.sql.SQLException;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {
    Optional<User> findByEmail(String email) throws SQLException;
}
