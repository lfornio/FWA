package edu.school21.cinema.repositories.Impl;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryImpl implements UsersRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAll() throws SQLException {
        return null;
    }

    @Override
    public void save(User user) throws SQLException {
        jdbcTemplate.update("INSERT INTO Users (Email, Firstname, Lastname, Phonenumber, Password) VALUES (?,?,?,?,?)",
                user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getPassword());

    }

    @Override
    public void update(User entity) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }

    @Override
    public Optional<User> findByEmail(String email) throws SQLException {
        User user = jdbcTemplate.query("SELECT * FROM Users WHERE email = '" +email + "'",
                        new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
        return Optional.ofNullable(user);
    }

}
