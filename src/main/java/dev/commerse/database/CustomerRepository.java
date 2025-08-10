package dev.commerse.database;

import dev.commerse.controllers.AuthController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    Logger logger = LoggerFactory.getLogger(CustomerRepository.class);
    private final NamedParameterJdbcTemplate jdbc;

    public CustomerRepository(NamedParameterJdbcTemplate jdbc)
    {
        this.jdbc = jdbc;
    }

    public void registerNewCustomer(String username, String password) {
        logger.info("Registering new customer " + username + " with password " + password);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(password);

        String sql = "INSERT INTO customer (username, password, role) VALUES (:username,:password, :role);";// SCARY !
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("username", username);
        params.addValue("password", encodedPassword);
        params.addValue("role", "USER"); //ADD THE CONSTANT VALUE

        jdbc.update(sql, params);

    }



}
