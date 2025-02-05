package com.bank.banking_app.service;

import com.bank.banking_app.entity.Account;
import com.bank.banking_app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public Account openAccount(Account account){
        return repository.save(account);
    }

    public double checkBalance(Long accountNumber){
        Account account = repository.findByAccountNumber(accountNumber);
        return (account !=null) ? account.getBalance() : 0.0;
    }

    public String credit(Long accountNumber , double amount){
        Account account = repository.findByAccountNumber(accountNumber);
        if(account != null) {
            account.setBalance(account.getBalance() + amount);
            repository.save(account);
            return "Account credited successfully";
        }
        return "Account not found";
    }
    public String debit(Long accountNumber , double amount){
        Account account = repository.findByAccountNumber(accountNumber);
        if(account !=null && account.getBalance() >=amount){
            account.setBalance(account.getBalance() - amount);
            repository.save(account);
            return "Account debited successfully";
        }
        return "Insufficient balance or account not found.";
    }
}
