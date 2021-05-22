package com.banking.app.model.dto;

import java.util.List;

import com.banking.app.model.Transaction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BankStatement {

    private Long accountNumber;

    private Double balance;

    private List<Transaction> transactions;
}