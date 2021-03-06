package com.veontomo.todo.server;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security configuration layer
 * @author Andrew
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/api/user/**")
            .permitAll()
            // .authenticated()
            .antMatchers("/api/admin/**")
            .permitAll();
        // .hasRole("ADMIN");
    }

}
