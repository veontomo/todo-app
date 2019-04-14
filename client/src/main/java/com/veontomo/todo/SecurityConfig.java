package com.veontomo.todo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Security configuration layer
 * @author Andrew
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Value("${todo-server.url}")
    private static String serverUrl;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user")
            .password(passwordEncoder.encode("pass"))
            .roles("USER");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/items")
            .authenticated()
            .and()
            .formLogin();

    }

    @Configuration
    @EnableOAuth2Client
    protected static class OAuthClientConfig {
        @Bean
        public OAuth2ProtectedResourceDetails resourceDetails() {
            final AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
            details.setClientId("todo-client");
            details.setClientSecret("todo-client-secret");
            details.setAccessTokenUri(serverUrl + "/oauth/token");
            details.setUserAuthorizationUri(serverUrl + "/oauth/authorize");
            details.setScope(Arrays.asList("read", "write"));
            details.setGrantType("authorization_code");
            details.setUseCurrentUri(true);
            return details;
        }

        @Bean
        public OAuth2RestTemplate redditRestTemplate(final OAuth2ClientContext clientContext) {
            return new OAuth2RestTemplate(resourceDetails(), clientContext);
        }
    }

}
