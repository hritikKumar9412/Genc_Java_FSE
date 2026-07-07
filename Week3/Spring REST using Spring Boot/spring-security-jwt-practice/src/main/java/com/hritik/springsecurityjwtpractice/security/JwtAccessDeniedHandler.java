package com.hritik.springsecurityjwtpractice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hritik.springsecurityjwtpractice.exception.ApiError;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class JwtAccessDeniedHandler
        implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,

                       HttpServletResponse response,

                       AccessDeniedException accessDeniedException)

            throws IOException, ServletException {

        ApiError error = new ApiError(

                LocalDateTime.now(),

                HttpServletResponse.SC_FORBIDDEN,

                "Forbidden",

                "Access Denied",

                request.getRequestURI()

        );

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        response.setContentType("application/json");

        new ObjectMapper().writeValue(response.getOutputStream(), error);

    }

}