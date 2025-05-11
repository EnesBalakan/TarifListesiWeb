package com.tarif.tarifListesiWeb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails enes = User.builder()
                .username("enes")
                .password("{noop}enes123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        UserDetails furkan = User.builder()
                .username("furkan")
                .password("{noop}furkan123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails mehmet = User.builder()
                .username("mehmet")
                .password("{noop}mehmet123")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(enes, mehmet, furkan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                        .anyRequest().authenticated() // Diğer tüm istekler için kimlik doğrulama
                )
                .formLogin(form -> form
                        .loginPage("/tarifler/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .defaultSuccessUrl("/tarifler/anaSayfa", true)
                        .permitAll()
                )
                .logout(logout->logout.permitAll()
                );

        return http.build();
    }
}
