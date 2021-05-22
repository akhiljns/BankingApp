package com.banking.app.controller;

import com.banking.app.model.Account;
import com.banking.app.model.Transaction;
import com.banking.app.model.dto.BankStatement;
import com.banking.app.model.dto.SummaryDto;
import com.banking.app.model.dto.TransactionDto;
import com.banking.app.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/open")
    public Account create(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PutMapping("/sendmoney")
    public ResponseEntity<Transaction> sendMoney(@RequestBody TransactionDto dto) {
        return ResponseEntity.ok().body(accountService.sendMoney(dto));
    }

    @GetMapping("/statement")
    public ResponseEntity<BankStatement> getStatement(@RequestBody SummaryDto summaryDto) {

        BankStatement bs = new BankStatement();

        bs.setAccountNumber(summaryDto.getAccNo());
        bs.setBalance(accountService.findAccountByAccNo(summaryDto.getAccNo()).getBalance_value());
        bs.setTransactions(accountService.getStatement(summaryDto.getAccNo(), summaryDto.getFromTimestamp(),
                summaryDto.getToTimestamp()));

        return ResponseEntity.ok().body(bs);

    }

}