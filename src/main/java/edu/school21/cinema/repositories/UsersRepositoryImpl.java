package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryImpl implements UsersRepository{

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
    public void save(User entity) throws SQLException {
        System.out.println("save");
//        jdbcTemplate.execute("");

    }

    @Override
    public void update(User entity) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }

    @Override
    public Optional<User> findByEmail(String email) throws SQLException {
        return Optional.empty();
    }

//    @Override
//    public void save(User user) {
//
//    }
}
