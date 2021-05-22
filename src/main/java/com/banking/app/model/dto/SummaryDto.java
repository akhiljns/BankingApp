package com.banking.app.model.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SummaryDto {

    private Long accNo;

    private Timestamp fromTimestamp;

    private Timestamp toTimestamp;

}