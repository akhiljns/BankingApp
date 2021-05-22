package com.banking.app.service;

import java.sql.Timestamp;
import java.util.List;

// import com.banking.app.exception.InvalidAccountNumberException;
import com.banking.app.exception.NotEnoughBalanceException;
import com.banking.app.model.Account;
import com.banking.app.model.Transaction;
import com.banking.app.model.TransactionType;
import com.banking.app.model.dto.TransactionDto;
import com.banking.app.repository.AccountRepository;
import com.banking.app.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Account createAccount(Account account) {
        accountRepository.save(account);
        return accountRepository.getById(account.getAccountNumber());
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findAccountByAccNo(Long accountNo) {
        Account account = accountRepository.getById(accountNo);
        return account;
    }

    public Transaction sendMoney(TransactionDto transactionDto) {

        Long fromAccountNumber = transactionDto.getSenderAccountNo();
        Long toAccountNumber = transactionDto.getRecepientAccountNo();

        Double amount = transactionDto.getAmount();

        Account fromAccount = accountRepository.getById(fromAccountNumber);
        Account toAccount = accountRepository.getById(toAccountNumber);

        if (fromAccount.getBalanceValue() >= amount) {
            fromAccount.setBalanceValue(fromAccount.getBalanceValue() - amount);
            Transaction transactionDebit = transactionRepository.save(new Transaction(fromAccountNumber,
                    TransactionType.DEBIT, amount, new Timestamp(System.currentTimeMillis())));
            fromAccount.getTransactions().add(transactionDebit);
            accountRepository.save(fromAccount);

            // update recepient
            toAccount.setBalanceValue(toAccount.getBalanceValue() + amount);
            Transaction transactionCredit = transactionRepository.save(new Transaction(fromAccountNumber,
                    TransactionType.CREDIT, amount, new Timestamp(System.currentTimeMillis())));
            toAccount.getTransactions().add(transactionCredit);
            accountRepository.save(toAccount);

            return transactionDebit;
        } else {
            throw new NotEnoughBalanceException("Not Enough Balance");
        }

    }

    public List<Transaction> getStatement(Long accountNo) {
        Account account = accountRepository.getById(accountNo);
        return account.getTransactions();
    }
}