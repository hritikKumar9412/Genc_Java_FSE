package com.cognizant.Loan.controller;

import com.cognizant.Loan.model.Loan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{number}")
    public Loan getLoan(@PathVariable String number) {

        return new Loan(
                number,
                "Car",
                400000,
                3258,
                18
        );
    }
}