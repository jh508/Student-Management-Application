package com.studentmanagement.StudentManagementApp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource source){
        return new JdbcUserDetailsManager(source);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((configurer) -> configurer
                        .requestMatchers("css/**", "/register/newuser").permitAll()
                        .requestMatchers("/student/list").hasRole("EMPLOYEE")
                        .requestMatchers("/student/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/student/list", true)
                        .loginProcessingUrl("/authenticateuser")
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll)
                .exceptionHandling((configurer) -> configurer.accessDeniedPage("/accessdenied"));

        return http.build();
    }

}

