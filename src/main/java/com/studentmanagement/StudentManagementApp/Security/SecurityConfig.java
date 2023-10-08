package com.studentmanagement.StudentManagementApp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder().username("Grandy").password("{noop}g").roles("EMPLOYEE").build();
        UserDetails joe = User.builder().username("j").password("{noop}j").roles("EMPLOYEE", "ADMIN").build();
        return new InMemoryUserDetailsManager(john, joe);
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((configurer) -> configurer
                        .requestMatchers("css/**").permitAll()
                        .requestMatchers("/student/list").hasRole("EMPLOYEE")
                        .requestMatchers("/student/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/student/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.DELETE, "/student/**").hasRole("EMPLOYEE")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/student/list", true)
                        .loginProcessingUrl("/authenticateuser")
                        .permitAll());

        return http.build();
    }

}

