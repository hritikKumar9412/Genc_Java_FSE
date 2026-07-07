package com.hritik.springsecurityjwtpractice.controller;

import com.hritik.springsecurityjwtpractice.model.Country;
import com.hritik.springsecurityjwtpractice.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/countries")
    @PreAuthorize("hasRole('USER')")
    public List<Country> getCountries() {

        return countryService.getCountries();

    }

}