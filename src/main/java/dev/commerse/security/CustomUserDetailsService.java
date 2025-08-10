package dev.commerse.security;

import dev.commerse.models.Customer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final JdbcTemplate jdbc;

    public CustomUserDetailsService(JdbcTemplate jdbc) { // Constructor initializes the JDBC
        this.jdbc = jdbc;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            String sql = "SELECT username, password, role FROM customer WHERE username = ?;";

            Customer customer = jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Customer.class), username);

            if (customer==null) { //This check will be removed.
                throw new UsernameNotFoundException("Username not found: " + username);
            }

            return User.builder()
                    .username(customer.getUsername())
                    .password(customer.getPassword())
                    .roles(customer.getRole()) // Role array formatına uygun hale getirildi .split(",")
                    .build();
        }
        catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("");
        }

    }
}
