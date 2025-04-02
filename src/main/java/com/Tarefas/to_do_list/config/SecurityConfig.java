package com.Tarefas.to_do_list.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Maneira correta para Spring Security 6.1+
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // Permite todas as requisições sem autenticação
                );

        return http.build();
    }
}
