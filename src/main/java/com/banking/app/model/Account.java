package com.banking.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {

    @Builder
    public Account(Double balanceValue, List<Transaction> transactions) {
        this.balanceValue = balanceValue;
        this.transactions = transactions;
    }

    @Id
    @GeneratedValue
    @Getter
    private Long accountNumber;

    @Getter
    @Setter
    @Column
    private Double balanceValue;

    @Getter
    @Setter
    @JoinColumn
    @OneToMany(cascade = { CascadeType.ALL })
    private List<Transaction> transactions;

}