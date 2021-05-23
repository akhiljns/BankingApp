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

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @GeneratedValue
    private Long transaction_id;

    @Column
    private String transaction_type;

    @Column
    private Double transaction_amount;

    @Column
    private Timestamp transaction_timestamp;

    public Transaction(String transaction_type, Double transaction_amount, Timestamp transaction_timestamp) {
        this.transaction_type = transaction_type;
        this.transaction_amount = transaction_amount;
        this.transaction_timestamp = transaction_timestamp;
    }

    

}