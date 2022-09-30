package com.desafio.tipocambio.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map<String, String> usuarios = Map.of(
                "italo", "ADMIN",
                "pedro", "USER"
        );
        String rol = usuarios.get(username);
        if (rol != null) {
            User.UserBuilder userBuilder = User.withUsername(username);
            String encryptedPassword = passwordEncoder().encode("12345");
            userBuilder.password(encryptedPassword).roles(rol);
            return userBuilder.build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
