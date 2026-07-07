package com.hritik.springsecurityjwtpractice.controller;

import com.hritik.springsecurityjwtpractice.dto.AuthRequest;
import com.hritik.springsecurityjwtpractice.dto.AuthResponse;
import com.hritik.springsecurityjwtpractice.service.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;

    private final JwtService jwtService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(
            @Valid @RequestBody AuthRequest request) {

        LOGGER.info("Authentication request received");

        try {

            authenticationManager.authenticate(

                    new UsernamePasswordAuthenticationToken(

                            request.getUsername(),

                            request.getPassword()

                    )

            );

        } catch (DisabledException ex) {

            LOGGER.error("User account disabled");

            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("User account is disabled.");

        } catch (BadCredentialsException ex) {

            LOGGER.error("Invalid username or password");

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password.");

        }

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(
                        request.getUsername());

        String token = jwtService.generateToken(userDetails);

        LOGGER.info("JWT generated successfully");

        return ResponseEntity.ok(

                new AuthResponse(token)

        );
    }

}