package dev.commerse.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth ->auth
                        .requestMatchers("/public/**", "/auth/signup" ).permitAll() // Public endpoints
                        .anyRequest().authenticated())
                .formLogin(form -> form // Our custom login form
                        .loginPage("/auth/login")
                        .defaultSuccessUrl("/")
                        .permitAll())
                .logout(logout -> logout // Redirection after user logs out.
                    .logoutSuccessUrl("/auth/login?logout")
                        .permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // For password hashing. ## Will be replaced with argon2!
    }

}
