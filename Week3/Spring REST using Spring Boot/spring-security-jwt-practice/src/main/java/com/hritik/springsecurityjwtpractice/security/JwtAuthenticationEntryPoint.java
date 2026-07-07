package com.hritik.springsecurityjwtpractice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hritik.springsecurityjwtpractice.exception.ApiError;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class JwtAuthenticationEntryPoint
        implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,

                         HttpServletResponse response,

                         AuthenticationException authException)

            throws IOException, ServletException {

        ApiError error = new ApiError(

                LocalDateTime.now(),

                HttpServletResponse.SC_UNAUTHORIZED,

                "Unauthorized",

                "Invalid or Missing JWT Token",

                request.getRequestURI()

        );

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        response.setContentType("application/json");

        new ObjectMapper().writeValue(response.getOutputStream(), error);

    }

}