package com.cognizant.account.controller;
import com.cognizant.account.client.LoanClient;
import com.cognizant.account.model.Loan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final LoanClient loanClient;

    public AccountController(LoanClient loanClient) {
        this.loanClient = loanClient;
    }

    @GetMapping("/loan/{number}")
    public Loan getLoanDetails(@PathVariable String number) {
        return loanClient.getLoan(number);
    }
}