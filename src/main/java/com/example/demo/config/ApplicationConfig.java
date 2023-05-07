package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // i have no idea what this shit is doing
@EnableWebSecurity // i have no idea what this shit is doing

public class ApplicationConfig {
    @Bean //i have no idea what this shit is doing
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } // I have no idea

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { //same
         http

                .csrf(csrf ->csrf.disable()) // yep
                .authorizeHttpRequests(auth->
                        auth.requestMatchers("/register**")
                            .permitAll()
                                .anyRequest().authenticated()
                )

                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll();
        return http.build();
    }



}