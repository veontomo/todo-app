package com.veontomo.todo;

import org.baeldung.security.MySavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 * Security configuration layer
 * @author Andrew
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder encoder;
    
    @Autowired
    private MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler;

    private SimpleUrlAuthenticationFailureHandler myFailureHandler = new SimpleUrlAuthenticationFailureHandler();


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.inMemoryAuthentication()
            .withUser("user")
            .password(encoder.encode("pass"))
            .roles("USER")
            .and()
            .withUser("admin")
            .password(encoder.encode("pass"))
            .roles("ADMIN");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
        .and()
        .exceptionHandling()
        .accessDeniedHandler(accessDeniedHandler)
        .authenticationEntryPoint(restAuthenticationEntryPoint)
        .and()
        .authorizeRequests()
        .antMatchers("/api/tasks/user/**").authenticated()
        .antMatchers("/api/tasks/admin/**").hasRole("ADMIN")
        .and()
        .formLogin()
        .successHandler(mySuccessHandler)
        .failureHandler(myFailureHandler)
        .and()
        .httpBasic()
        .and()
        .logout();
        
        
        
        
        http.csrf()
            .disable()
            .exceptionHandling()
            .authenticationEntryPoint(restAuthenticationEntryPoint)
            .and()
            .antMatchers("/api/tasks")
            .authenticated()
            .antMatchers("/api/tasks/admin/**")
            .hasRole("ADMIN")
            .antMatchers("/css/styles.css", "/css/bootstrap.min.css", "/css/fontawesome.css")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .and()
            .httpBasic();
    }

}
