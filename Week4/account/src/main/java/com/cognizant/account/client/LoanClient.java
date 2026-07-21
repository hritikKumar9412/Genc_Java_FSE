package com.cognizant.account.client;

import com.cognizant.account.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "loan-service")
public interface LoanClient {

    @GetMapping("/loans/{number}")
    Loan getLoan(@PathVariable String number);

}