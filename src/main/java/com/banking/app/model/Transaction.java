package com.banking.app.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    private Long transaction_id;

    @Column
    private TransactionType transaction_type;

    @Column
    private Double transaction_amount;

    @Column
    private Timestamp transaction_timestamp;

    @ManyToOne
    private Account account;

}