package com.banking.app.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue
    private Long transactionId;

    public Transaction(Long accountNumber, TransactionType transactionType, Double transactionAmount,
            Timestamp transactionTimestamp) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionTimestamp = transactionTimestamp;
    }

    @Getter
    @Setter
    @Column
    private Long accountNumber;

    @Getter
    @Setter
    @Column
    private TransactionType transactionType;

    @Getter
    @Setter
    @Column
    private Double transactionAmount;

    @Getter
    @Setter
    @Column
    private Timestamp transactionTimestamp;

}