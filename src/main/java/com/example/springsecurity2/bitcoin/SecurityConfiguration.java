package com.example.springsecurity2.bitcoin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/crypto")
                // instead of asking any request to have the permitAll() method apply to it,
                // we are saying that any request actually needs to be authenticated() in order to proceed
                .authenticated()
                // The and() after the call to authenticated() allows us to chain
                // together all the calls we need in order to configure our Spring Security,
                .and()
                // The next instruction we give to Spring Security is to enable formLogin() as the authentication method.
                .formLogin()
                .and() // add to the chain
                .httpBasic()
                .and()
                .logout(); // request a logout form

        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // We create a user details service that can manage all the users we will add to it "in memory"
        // this means these users will not be saved to file or in a database anywhere, and will cease to exist when the application is stopped.
        // This would not work for a production-level application,
        // but it is a good way to demonstrate the mechanism of UserDetailsService without having to worry about persistence or service integration.
        InMemoryUserDetailsManager userDetailService = new InMemoryUserDetailsManager();

        // we have given our user1 the "read" authority
        UserDetails user1 = User.withUsername("user")
                .password(passwordEncoder().encode("1234"))
                .authorities("read")
                .build();
        userDetailService.createUser(user1);
        return userDetailService;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
