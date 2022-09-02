package com.bookproject.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * Configures security for permitAll() requests, for example for Swagger, where no authentication is needed. Requests
 * with an Authorization header that does not have the value Basic or Bearer, or that have no Authorization header, will
 * go here
 */
@Configuration
public class ApiPermitAllWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requestMatcher(getNoAuthRequestMatcher())
            .csrf()
            .disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/books").permitAll()
            .anyRequest().denyAll();
    }

    private RequestMatcher getNoAuthRequestMatcher() {
        return request -> {
            String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

            if (StringUtils.startsWithIgnoreCase(authorizationHeader, "Bearer")) {
                return false;
            }

            return !StringUtils.startsWithIgnoreCase(authorizationHeader, "Besic");
        };
    }
}
