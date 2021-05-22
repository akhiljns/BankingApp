package com.banking.app.controller;

import java.util.List;

import com.banking.app.model.Account;
import com.banking.app.model.Transaction;
import com.banking.app.model.dto.BankStatement;
import com.banking.app.model.dto.TransactionDto;
import com.banking.app.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/open")
    public Account create(@RequestBody Account account) {
        return accountService.createAccount(account);

    }

    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return accountService.findAll();
    }

    @PutMapping("/sendmoney")
    public ResponseEntity<Transaction> sendMoney(@RequestBody TransactionDto dto) {
        return ResponseEntity.ok().body(accountService.sendMoney(dto));
    }

    @GetMapping("/statement")
    public ResponseEntity<BankStatement> getStatement(@RequestBody Long accountNo) {

        BankStatement bs = new BankStatement();
        bs.setAccountNumber(accountNo);
        bs.setBalance(accountService.findAccountByAccNo(accountNo).getBalanceValue());
        bs.setTransactions(accountService.getStatement(accountNo));

        return ResponseEntity.ok().body(bs);

    }

}