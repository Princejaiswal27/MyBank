package com.bank.banking_app.controller;

import com.bank.banking_app.entity.Account;
import com.bank.banking_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService service;

    @PostMapping("/open")
    public Account openAccount(@RequestBody Account account){
        return service.openAccount(account);
    }

    @GetMapping("/balance/{accountNumber}")
    public double checkBalance(@PathVariable Long accountNumber){
        return service.checkBalance(accountNumber);
    }

    @PostMapping("/credit/{accountNumber}/{amount}")
    public String credit(@PathVariable Long accountNumber, @PathVariable double amount){
        return service.credit(accountNumber , amount);
    }

    @PostMapping("/debit/{accountNumber}/{amount}")
    public String debit(@PathVariable Long accountNumber, @PathVariable double amount){
        return service.debit(accountNumber , amount);
    }
}
