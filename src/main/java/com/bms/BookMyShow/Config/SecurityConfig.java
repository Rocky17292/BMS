package com.bms.BookMyShow.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
             .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/bms/public/**").permitAll()
                .requestMatchers("/bms/user/**").hasRole("USER")
                .requestMatchers("/bms/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .httpBasic();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Create in-memory users with roles
        var user = User.withUsername("user")
            .password("{noop}password")
            .roles("USER")
            .build();

        var admin = User.withUsername("admin")
            .password("{noop}admin")
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
