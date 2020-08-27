package com.qa.billyshakes.service;

import com.qa.billyshakes.domain.Account;
import com.qa.billyshakes.exceptions.error404;
import com.qa.billyshakes.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository aRepo;

    @Autowired
    public AccountService(AccountRepository nRepo) {
        this.aRepo = nRepo;
    }

    public List<Account> readAccount(){
        return this.aRepo.findAll();
    }

    public Account createAccount(Account account){
        return this.aRepo.save(account);
    }

    public Account findAccountById(Long id){
        return this.aRepo.findById(id).orElseThrow(error404::new);
    }

    public Account updateAccount(Long id, Account account){
        Account update = findAccountById(id);
        update.setEmail(account.getEmail());
        update.setPassword(account.getPassword());
        update.setFirstname(account.getFirstname());
        update.setLastname(account.getLastname());
        update.setUsername(account.getUsername());
        return this.aRepo.save(update);
    }

    public Boolean deleteAccountById(Long id){
        if(!this.aRepo.existsById(id)){
            throw new error404();
        }
        this.aRepo.deleteById(id);
        return this.aRepo.existsById(id);
    }
}
