package com.Tienda.Ropa.Seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Seguridadaconf {
    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

  @Bean
public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/catalogo", "/nosotros", "/login", "/registrar", "/logout", "/css/**", "/js/**", "/images/**").permitAll()
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/cliente/**").hasRole("CLIENTE")
            .requestMatchers("/intranet").authenticated()
            .anyRequest().permitAll()
        )
        .formLogin(form -> form
            .loginPage("/login")  // Tu página personalizada
            .loginProcessingUrl("/login") // URL a la que envía el form
            .successHandler(customAuthenticationSuccessHandler) // Redirección por rol
            .permitAll()
        )
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/index.html")
            .permitAll()
        )
        .csrf(csrf -> csrf.disable())
        .build();
}
}