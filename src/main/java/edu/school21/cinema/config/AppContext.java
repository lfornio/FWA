package edu.school21.cinema.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.cinema.repositories.UsersRepository;
import edu.school21.cinema.repositories.UsersRepositoryImpl;
import edu.school21.cinema.services.Impl.PasswordEncoderServiceImpl;
import edu.school21.cinema.services.Impl.UsersServiceImpl;
import edu.school21.cinema.services.PasswordEncoderService;
import edu.school21.cinema.services.UsersService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan("edu.school21.cinema")
public class AppContext {
    private final String FILE_NAME = "C:\\Users\\Elena Temyach\\Desktop\\FILES\\SCHOOL 21\\FWA\\FWA\\src\\main\\webapp\\WEB-INF\\application.properties";

    @Bean
    DataSource dataSource() {
        HikariConfig config = new HikariConfig(FILE_NAME);
        DataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    UsersRepository usersRepository(JdbcTemplate jdbcTemplate) {
        return new UsersRepositoryImpl(jdbcTemplate);
    }

    @Bean
    UsersService usersService(UsersRepository usersRepository) {
        return new UsersServiceImpl(usersRepository);
    }

    @Bean
    PasswordEncoderService passwordEncoderService() {
        return new PasswordEncoderServiceImpl();
    }
}
