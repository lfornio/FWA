package edu.school21.cinema.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.cinema.repositories.UsersRepository;
import edu.school21.cinema.repositories.UsersRepositoryImpl;
import edu.school21.cinema.services.UsersService;
import edu.school21.cinema.services.UsersServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan("edu.school21.cinema")
public class AppContext {

    @Bean
    DataSource dataSource() {
        HikariConfig config = new HikariConfig("application.properties");
        DataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    UsersService usersService() {
        return new UsersServiceImpl(usersRepository());
    }

    @Bean
    UsersRepository usersRepository() {
        return new UsersRepositoryImpl(jdbcTemplate(dataSource()));
    }

}
