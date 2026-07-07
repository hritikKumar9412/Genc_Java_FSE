package com.hritik.springsecurityjwtpractice.config;

import com.hritik.springsecurityjwtpractice.filter.JwtAuthorizationFilter;
import com.hritik.springsecurityjwtpractice.security.JwtAccessDeniedHandler;
import com.hritik.springsecurityjwtpractice.security.JwtAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthorizationFilter jwtAuthorizationFilter;

    private final JwtAuthenticationEntryPoint authenticationEntryPoint;

    private final JwtAccessDeniedHandler accessDeniedHandler;

    @Bean
    public UserDetailsService userDetailsService() {

        return new InMemoryUserDetailsManager(

                User.withUsername("user")
                        .password(passwordEncoder().encode("pwd"))
                        .roles("USER")
                        .build(),

                User.withUsername("admin")
                        .password(passwordEncoder().encode("pwd"))
                        .roles("ADMIN")
                        .build(),

                User.withUsername("manager")
                        .password(passwordEncoder().encode("pwd"))
                        .roles("USER", "ADMIN")
                        .build()

        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration)
            throws Exception {

        return configuration.getAuthenticationManager();

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http

                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/authenticate").permitAll()

                        .requestMatchers("/countries").hasRole("USER")

                        .requestMatchers("/admin").hasRole("ADMIN")

                        .anyRequest().authenticated()

                )

                .exceptionHandling(exception -> exception

                        .authenticationEntryPoint(authenticationEntryPoint)

                        .accessDeniedHandler(accessDeniedHandler)

                )

                .httpBasic(Customizer.withDefaults())

                .addFilterBefore(

                        jwtAuthorizationFilter,

                        UsernamePasswordAuthenticationFilter.class

                );

        return http.build();

    }

}