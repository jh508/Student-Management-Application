package com.studentmanagement.StudentManagementApp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails test = User.builder().username("Grandy").password("{noop}g").roles("EMPLOYEE").build();
        UserDetails test2 = User.builder().username("j").password("{noop}j").roles("EMPLOYEE", "ADMIN").build();
        return new InMemoryUserDetailsManager(test, test2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((configurer) -> configurer
                        .requestMatchers("css/**").permitAll()
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

