package com.qa.billyshakes.rest;

import com.qa.billyshakes.domain.Account;
import com.qa.billyshakes.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public List<Account> getAllAccount(){
        return this.accountService.readAccount();
    }

    @PostMapping("/createAccount")
    public Account createAccount(@RequestBody Account account){
        return  this.accountService.createAccount(account);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteAccount(@PathVariable Long id){
        return this.accountService.deleteAccountById(id);
    }

    @GetMapping("/getNoteById/{id}")
    public Account getAccountById(@PathVariable Long id){
        return this.accountService.findAccountById(id);
    }

    @PutMapping("/updateNote/{id}")
    public Account updateNote(@PathVariable Long id, @RequestBody Account account){
        return this.accountService.updateAccount(id, account);
    }
}
